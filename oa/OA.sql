-- MySQL dump 10.13  Distrib 5.6.22, for Win64 (x86_64)
--
-- Host: localhost    Database: OA
-- ------------------------------------------------------
-- Server version	5.6.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ACT_EVT_LOG`
--

DROP TABLE IF EXISTS `ACT_EVT_LOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_EVT_LOG` (
  `LOG_NR_` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_STAMP_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DATA_` longblob,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
  `IS_PROCESSED_` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`LOG_NR_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_EVT_LOG`
--

LOCK TABLES `ACT_EVT_LOG` WRITE;
/*!40000 ALTER TABLE `ACT_EVT_LOG` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_EVT_LOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_GE_BYTEARRAY`
--

DROP TABLE IF EXISTS `ACT_GE_BYTEARRAY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_GE_BYTEARRAY` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTES_` longblob,
  `GENERATED_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_BYTEARR_DEPL` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_BYTEARR_DEPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_GE_BYTEARRAY`
--

LOCK TABLES `ACT_GE_BYTEARRAY` WRITE;
/*!40000 ALTER TABLE `ACT_GE_BYTEARRAY` DISABLE KEYS */;
INSERT INTO `ACT_GE_BYTEARRAY` VALUES ('14',1,'bpmn/CountSalary.bpmn','13','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:activiti=\"http://activiti.org/bpmn\"\n	xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\"\n	xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\"\n	expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.activiti.org/test\">\n	<process id=\"CountSalary\" name=\"计算薪资\">\n		<startEvent id=\"startevent1\" name=\"Start\"></startEvent>\n		<serviceTask id=\"servicetask1\" name=\"系统记录薪资\"\n			activiti:expression=\"${processService.recordSalary(execution)}\"></serviceTask>\n		<endEvent id=\"endevent1\" name=\"End\"></endEvent>\n		<sequenceFlow id=\"flow3\" name=\"\" sourceRef=\"servicetask1\"\n			targetRef=\"endevent1\"></sequenceFlow>\n		<sequenceFlow id=\"flow4\" name=\"\" sourceRef=\"startevent1\"\n			targetRef=\"servicetask1\"></sequenceFlow>\n	</process>\n	<bpmndi:BPMNDiagram id=\"BPMNDiagram_CountSalary\">\n		<bpmndi:BPMNPlane bpmnElement=\"CountSalary\" id=\"BPMNPlane_CountSalary\">\n			<bpmndi:BPMNShape bpmnElement=\"startevent1\"\n				id=\"BPMNShape_startevent1\">\n				<omgdc:Bounds height=\"35\" width=\"35\" x=\"310\" y=\"200\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"servicetask1\"\n				id=\"BPMNShape_servicetask1\">\n				<omgdc:Bounds height=\"55\" width=\"105\" x=\"420\" y=\"190\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"endevent1\" id=\"BPMNShape_endevent1\">\n				<omgdc:Bounds height=\"35\" width=\"35\" x=\"590\" y=\"200\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNEdge bpmnElement=\"flow3\" id=\"BPMNEdge_flow3\">\n				<omgdi:waypoint x=\"525\" y=\"217\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"590\" y=\"217\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow4\" id=\"BPMNEdge_flow4\">\n				<omgdi:waypoint x=\"345\" y=\"217\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"420\" y=\"217\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n		</bpmndi:BPMNPlane>\n	</bpmndi:BPMNDiagram>\n</definitions>',0),('15',1,'bpmn/CountSalary.CountSalary.png','13','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0{\0\0\0�\0\0\0��p\0\0}IDATx���KlT�`�Yv�evYf�U�H�]V��p��∇�C�x�y`(�b�(\rxS!��P@\"Di)��Z�\n\r�P7��C0��Ğ�s\\�s=1�_�0�}��xx���߿9�y�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0x�$I�ؕ+W�8u�Tr�ر���I+�v����ĉ��\Zݥ\0��Š��Ғܺu+�J�uuu%��͙�\Zܩ\0���=A��_SSӀ;\0��8t+T�v�ú�T\0`Zb���=\0@�K:�����{~��ǂ��\0����?�t����Ŀ;G�^|�}��7��7w�3a\0�+a/�=\'���?К��7��Kɦ��\Z\r{�q|����ԅ�����;�>a\0�a�;�ɺ��������]H���G8�\0���b;|�}�ao�߮	f�^I���x2�w���3.�~-ɶ��P��nxM[x�;���j\0�lÆ\rO�ܹ�/����7n���M���F��e˒�k�f6o��^w��^���V���n�an;ɇ��\\��f�������x�]0��j��kC���vShwC��3�<�+	0[�l��o��W]]�lڴ)9t�P���:�����`���ݝ���%G�I\Z\Z\Z�E���7��o������6.�H�ы�.�u����g���\n-��E�ݛf��m���U���+W�x���}K�,I80�����ɓ\'�bmm�P�{����{�\r��޼�����{��&�0��\rlq�`۶mõ��ŋIGGGr����Z?\\~��g����_?L������+0	!�X�xq�{��7���g�&K�.M^z饎�	�qWX���O����7\Z�jjj�={�����u)�2��c_EEE&�+]m�	���]z�嗓O?�4�M===Ɏ;bq�?�S���=ø�^���Y���=x3��>|x����2!�5��\0	z+V����ػwoR]]�y��~��^��n�F�h��\nf�^��ޘ�8\\���;S���ɚ5kr{��t�R��m���g�����c��×��w�u�[���73a/�r��>}:/u%�����=|����z\0��1F��w����P>������+ug/��M����\r{k�_>6M8�������S\\̱u��1���=��@٫���cګ��\Z�~��섽޾������C���z��K��;.-���L��p׉����~�L�˛��ݗ��7�C����Rù�@Y�����Ufc��t��TVVf|򞝰�\r|���[p`d�^|�}��>AO�˫�\r�GW��t1�T�f��\\\'n\0e-n���*���z�?���N�N�o�n6�Yu+�R�������J����S�����xZ<c�&�r�^<�2c�^~&�C�Oo�\\��_�._�<f��ŋ?�z\0e����T�GSl˗/���zG�=a�	{�f�V\\![,�M�C�٦z\0e������O>)z�۾}{����a��Ʉ^aO�+��4�j�D���g�P�6n�8���Z�w��龸骰7:��;�`Z\"�	{s�>Mo����V�ڒ��׭�e����(siruvv�������>^��\'��}\Z��~���ps]�~}̞{�>Pv���B�{5�{��!:�#��a*�	{�~����\'[K�d9�Q����B!���hJ6���R�Oӿ/��\"�z�J$�i�k�^�7���=��P*s�����ٛ���^EEśٽ���??n�+_׳W��Ԝ=��aÆ�ŋKb5n(�w���C^V���Dϕ�ׅ��ܧV�������ÇKe���?�(�C�n�\0�a��{�^�ߧ�kJa���o���T}���ر��֭[��V�X�~h���������v�VVV6��	\Zk֬Io�ܠ�eg���O���Iooo1��\nA/�����wdr�=a��UUU=�>�������F�ޓ�P�֭[�����ha����\rE��;!�	{�������466����*P����~�z��l�{+++3��;!�	{���Pn\\�_�-X��ۇ{S��*P�B!jii)xث���o���{�l�\"�M��,����СC�-�7oN���T5���t����%�o�.X1>w�܃�����̝��	{��݋=mW�^�{m�;���-X����	�`���7�y睂�޼ysx�6ᵮ��\'�=�B����U�V�uA�ɓ\'�߆��w\0`Dry���}����\Z��555�Č�\\uaO�{�͟?�����,n��1�G��Ţ��ĭ	���3�Z9{�b�E���-�	{eU[�����8����{V�nsz�Lx��26��]�v\r�a�^F���\'앧x�Fz.]셋Ǚ�t��믿�{|��0���:�*�k׮�x{���6.�0GO���[�!�e��,��1��s��q��޼�[A`j�oiC[�l�r�ʔz���;w�썽y�﹨\0{�Q�	φP6�ҒW^y%ٻwo����v����1��^�x��u�r��\03CZ(�ͱ8/[�l��߾{����P|�,����\nŸo���=#g����l�,�	{<������f�i{����[2��B�6]pC���v&<^�[aO�㇌��ے^�1����1\0�4ao�G���098·��x�N���yŮ\Z\0&�\0&�\0&�\0&�\0�\00�cǎ	T�\0�jii�u�PU��ƍ�B�p�\0�r���_677g���K���ѣG�\r���\n\0L[o655݋ÅZI�A\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0����Oaj��L\0\0\0\0IEND�B`�',1),('18',1,'bpmn/ExpenseAccount.bpmn','17','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:activiti=\"http://activiti.org/bpmn\"\n	xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\"\n	xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\"\n	expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.activiti.org/test\">\n	<process id=\"ExpenseAccount\" name=\"报销申请\">\n		<startEvent id=\"startevent1\" name=\"Start\"></startEvent>\n		<userTask id=\"usertask1\" name=\"财务审批\"\n			activiti:candidateGroups=\"finance\"></userTask>\n		<serviceTask id=\"servicetask1\" name=\"银行转账\"\n			activiti:expression=\"${processService.bankTransfer(execution)}\"></serviceTask>\n		<boundaryEvent id=\"boundaryerror1\" cancelActivity=\"false\"\n			attachedToRef=\"servicetask1\">\n			<errorEventDefinition></errorEventDefinition>\n		</boundaryEvent>\n		<userTask id=\"usertask2\" name=\"填写申请\"\n			activiti:candidateGroups=\"employee\"></userTask>\n		<endEvent id=\"endevent1\" name=\"End\"></endEvent>\n		<userTask id=\"usertask3\" name=\"现金支付\"\n			activiti:candidateGroups=\"finance\"></userTask>\n		<sequenceFlow id=\"flow1\" name=\"\" sourceRef=\"startevent1\"\n			targetRef=\"usertask2\"></sequenceFlow>\n		<sequenceFlow id=\"flow2\" name=\"\" sourceRef=\"usertask2\"\n			targetRef=\"usertask1\"></sequenceFlow>\n		<sequenceFlow id=\"flow3\" name=\"\" sourceRef=\"usertask1\"\n			targetRef=\"servicetask1\"></sequenceFlow>\n		<sequenceFlow id=\"flow6\" name=\"\" sourceRef=\"boundaryerror1\"\n			targetRef=\"usertask3\"></sequenceFlow>\n		<sequenceFlow id=\"flow7\" name=\"\" sourceRef=\"usertask3\"\n			targetRef=\"endevent1\"></sequenceFlow>\n		<sequenceFlow id=\"flow8\" name=\"\" sourceRef=\"servicetask1\"\n			targetRef=\"endevent1\"></sequenceFlow>\n	</process>\n	<bpmndi:BPMNDiagram id=\"BPMNDiagram_ExpenseAccount\">\n		<bpmndi:BPMNPlane bpmnElement=\"ExpenseAccount\"\n			id=\"BPMNPlane_ExpenseAccount\">\n			<bpmndi:BPMNShape bpmnElement=\"startevent1\"\n				id=\"BPMNShape_startevent1\">\n				<omgdc:Bounds height=\"35\" width=\"35\" x=\"70\" y=\"130\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"usertask1\" id=\"BPMNShape_usertask1\">\n				<omgdc:Bounds height=\"55\" width=\"105\" x=\"300\" y=\"120\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"servicetask1\"\n				id=\"BPMNShape_servicetask1\">\n				<omgdc:Bounds height=\"55\" width=\"105\" x=\"460\" y=\"120\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"boundaryerror1\"\n				id=\"BPMNShape_boundaryerror1\">\n				<omgdc:Bounds height=\"30\" width=\"30\" x=\"500\" y=\"160\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"usertask2\" id=\"BPMNShape_usertask2\">\n				<omgdc:Bounds height=\"55\" width=\"105\" x=\"150\" y=\"120\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"endevent1\" id=\"BPMNShape_endevent1\">\n				<omgdc:Bounds height=\"35\" width=\"35\" x=\"642\" y=\"130\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"usertask3\" id=\"BPMNShape_usertask3\">\n				<omgdc:Bounds height=\"55\" width=\"105\" x=\"462\" y=\"220\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNEdge bpmnElement=\"flow1\" id=\"BPMNEdge_flow1\">\n				<omgdi:waypoint x=\"105\" y=\"147\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"150\" y=\"147\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow2\" id=\"BPMNEdge_flow2\">\n				<omgdi:waypoint x=\"255\" y=\"147\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"300\" y=\"147\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow3\" id=\"BPMNEdge_flow3\">\n				<omgdi:waypoint x=\"405\" y=\"147\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"460\" y=\"147\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow6\" id=\"BPMNEdge_flow6\">\n				<omgdi:waypoint x=\"515\" y=\"190\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"514\" y=\"220\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow7\" id=\"BPMNEdge_flow7\">\n				<omgdi:waypoint x=\"567\" y=\"247\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"659\" y=\"247\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"659\" y=\"165\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow8\" id=\"BPMNEdge_flow8\">\n				<omgdi:waypoint x=\"565\" y=\"147\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"642\" y=\"147\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n		</bpmndi:BPMNPlane>\n	</bpmndi:BPMNDiagram>\n</definitions>',0),('19',1,'bpmn/ExpenseAccount.ExpenseAccount.png','17','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0�\0\0\0\0\0\"��~\0\0�IDATx���[p���^�K��M���Ӌ:ә�/p�z�gpLI���*��A����\r�.��x�=�jld���@�9�Ĩ@H��=kX�++	HV�����<��@\\�Û��~���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�0I��ڿ��-[�$�֭K���U���!ٸqcWZ���W�O�\\|SSSr��ɤ��Ce�ZZZ���Ʈt�_������ 3�l�����J�+���\0R��4���+����H�\0b 5��+}e\\S���A�����m�\'�\rr?���y}���9���-y������\r�T� ���ɮ�Ov�sf����9�A^_�r���;����ݿ�����\Z?�?~��g�����1dn~�W��ב�w�y}��ʢ�\"�����d�ڝɿ>?�4~q<y��]��5~���#�c�k����ɩ6V�e2���~CF<g 6��+}U����ɣkvv�իՌ�w$��=�_�Pn!cW�����x�@l��W��\\����G�9����^�e����gi=����v�رc�O��V������3�kv�?!���eԜ9s~�r��.\\xv�ܹ�S�NMjjj�/��ɓ�Gy�k�����x�\'n^�����W���T Ng�ޑ���@�������c����a��+/��s�#i�9VTPg�zv��ѣ���hѢ�O>�d{mmm���\'o��f�s���&֗.]J�Z[[�ݻw\'uuuɒ%K�q��E������*�b^KȈ����� ���U��/v��\n׸FX-~]<V�6~�]�_֥�s\\Zm�Z��#fc���d����1k֬��\'&k׮ͅӁ�p�B�iӦ\\�:ujg��,\Z��u�����x�@l��W�*���ײ��m-~]<��k����pp�R@�S�ŋ�Osssr����ܹs��&&���ٓ������d]!�%�sn��P\Z8�>���/���={6�Q۶mK&M������?�~Gr�H\n��Gw&��5��G��c�� �����_iE����;pN�0!y��s�t \"\'ŧ�ӧO�`�������t�v	<��c_��H>��d0�>}:Y�bE4ǥ1c��b��ר�?~�WȈ��y}��,P����5\r��\n�f|J3�7\"�R���=�J�+\r�K��C\\�M�6��:��^Kjkk����ߌ��z�|�w�����sb����W���_�����zE�e4���q�����ܨ�G�&3g�,������1�:��5ﭷފ\0[�3�Wq�ўM�wmb<�4$����W��u;�}�����^��S����?��kdc=l�luu��� ���b����ۓRy�W.���/���ϟO��]�|^7�߀��xM��l�A^_�,�_R�k]kx}d͎�1��E�e(��+�qJqs�SO=�c��C֕�����R{衇�B���A�j�bf���J_�cx=�~>Y�~oni��||(��ŉ^���>�qDl���6�K���I�eH�7�׸�R�+��7�,�ԕ��kl�5�\n\\Ϻ����r�N��A�ZfŮ4[f`6��+}��e`O|��7`�\rY��\Z?�?���v�U�e���w�ћ�\"n�/\\>�D�A�^e������X�R)����|�\r��J_e5���A>��U@�e|���|���J-o*�[]�G���Y=�`�g_��r\\�:�A^�����J�\r�r��@P�Ӌ�۷����<��O\\��jժ-��c�M�2%�S�j�Wy}���^9�>����p)<� �<�]��p�³��ΰ�ץK����ҁ���z-a� o��W���>6����\\���c�R�0p%�W�v��`�;wn�Ν;�=�~���ip��1��5m��y���R^������zվ.<�`���Ùu\n׽��z�i�ԩò��؉\'.��g�ǐ�����3�����*�/��O�Ubx����.�/�.�:�c�WW�:���R�sv-�bf�C�wJ��(�y}���������^{�u��q��p�C\n�.��\r\\�(�����]|<a�7��+}U_���������ׅ��B�^+l��� ��*Ǿ�r��qM����2�j��iii����|�UUU���I��A>���Y�z����We3C���_%μv��5�fΜ9]��͙�m ���2�����^k��\Zp��|� ���U���?�W��W_�m���>���nV�yݚ�gb#��N�2�����*�/��O�Ubx����vda���o�}w�z�iŊ۞z�a�ӦM;�6���c�sF� o��W���ë���^�����ի�p��̙3)X��]�3f���{�MΞ=;�{�v��5�0a�M����\r��J_U\Z���*MMMͭ��7��>}zX׻^�?sen���>z���q������Ϧq�A� o��W�J��?�u(�{}�7J�uV�ZU^��\"7���ی3�eˬ�񭮮���y����W�O�	�C�p�@�T�-��=���-���rEAz!;���J^.\\x��-�RƖ2�J_	��O�e��-����o�Y���`���Y�c�� �4iҬ�����d��O?��~\'ta�ر7�A^_�+���_�f_c&���C�ubG�µ���s���hʔ)G�-[V��ǎ�-H/�#ye��W�J�)�W\ni�<��?��ް�iӦ��z��)�����/�8��5N�0aB���?ye��W�J�)�W*cƌ�E\Z\";�2��c[�\"��Y�MZ�[7���v\r՝x1�\Z�5��[�� �����ڳgO�~�����+Wq�L��q��%�>�h�ꫯ&/^�#3�LL�+,cMjkk�.(�qm)�%�e!��O��{�sָvU��a��W�Jx�fm۶-F��_~��ע��<>�}7���ߟ|��I{{��!�4�µ�1K\ZǷ�����+>�Vp-�l\Zb��.���bW��9��׸\nB��R�k6+fQc���g�Ʌ��ܿ���g�N�Ν��ݻW���I�p�U6��ݻw�\0��ǵh�5�T@p��&\r���-:�~g:���89k�ʕgc�5�s�+�\nB���WƵ�3g��\'�uuuI�aD��iF�#\r���Bg��?�1y�ג�F4v%ȯ���?���k�斠�^7gecj���\"4�ŝ<yr��O?}f���gӋ���������b�/]���i��Ǒ�qrV�@ d�J	�ٯ��~;�Qm��������?�կ~��\Z5�{�֟����ĉs���\n�ѡ����o��-ų��Y�l����؉��lKZ/Xz���3imM>}	7U��!d�J_׆��lْ�!�5��b��?�ir뭷�>�����\'*EX�u�O?�t��_�:��x}������9b�-헦�P{���A^	�J_�~���㹛�\no���Z[[��Y}���u���������)�o����↭�?롇J��ۧ�F��|��v��ɺK}Lֵ�	�i�}&��a�W«k����+��Uaؼ뮻��o�=iii�=�t��d�����f͚~׺ƚ���w�yg�3�㽈������:,�:���\\�ye��W�J�\r���I f\\#��oފ��c��ʕ+�8=2�/�}l瘌3&P\n͚5+�<A��\\��� ��yG0�+����W�o@K\nl�Y������W6⤣X�\ZAv�����b�}�]2y�䤱�1���p\rlsss.��\\��o������ ���J_�k>9+��ʯa��⦫X�Z���G�MLN�:ս �ǆ\rzݘ�6��x]�y��d�$.ᵤ��D7g��=z�w��2��+}���Zo��V����X���_���l�O<���?/f\\��\"+h��իs�d�̙ݏ�.�a8k[g	��7�Zp��b�e)�d��\\��W�ʸV�ʟ��7mڴ8ű�Ɏ��չ-����d�����>�;iŊ�_�ܹ37�\Za��������V�ܼ8i2���#.��\\ak�3�!�RSSSg�/�y6�ȑ#�A�C_)}U9��\Z�\Zּ8� NA*��G��\'�|�<����~���m�\"��s�{b�k���޺uk��}`c\rm�7�|�̘1C��u����~7����Ʈ�|Q�^�hhh���}��U��_����=��\n��ߓ��/7K3�Q�< �g��\Z�#^�|����G��\Z���\r׸q����\n�\'��`;P��Ad~�]p[|��2U�<��+}������\nCf^̶��w��b�@����5����{n��͹%q>}��?7^��F|��\\\0�\r6tn�U<�\Z\'o�g�fϞ��R��o��͜ƞ�y�� fa��^x�GP-�ymoo�\\�\0��ő�P�[�����������u1�8�c�x���#��y=v�XG��s�}�ջ\0\0Ȝ9s.n߾���b����s����E�u?7E���	\n�6����M�g����\0`@/^�����}^c�@܄�t��>�����~��g�_ϛ7��^�����zw�#�\0��ޗ�9����/��2�emmm}���?�pn۫���m�^z���넭�O���\0�u�O��e���\Zո�*v��X�\Z!dٲe�?�����b��[n�%)��M5y�^�	�7ũ��	3fQ������g�����\Z�p�/��ֻ�+�x�������uwx�^��`������z$����o�qW_��ۗ�QkΜ9�3���[��ֲe�v�F�G��Gx\0���w�����?9t�P�\03���������[���Jn�k,�`R\\���{$}�����ʻ��\n\0ܰ���/�4iR��\\�k`㦫؅ �ъ}`��4�ĺ��2��n˽�h�kh�8q��4�<�]Fx\0Mmm�s8\\�>#�Ƭj��I\\��s�5�q��٢]r��i��Ex\0�L܇����������_��o���\0@I�?�qʔ)��7oN.\\�pͩ����Pmmm[\ZNNY��\n\0�Luu���N�A�k���_�}\\q>A>̦?v<x0����/�M��mi(93�v@x\0�+��1a�\n�ǥQcǎ�PSSs�w	�\0>�?\0\0��\0>@�\0\0��\0@�@�\0\0��\0@�@�\0\0�\0@�\0�\0�\0\0��\0�\0\0��\0 |�\0\0���\0\0��\0 |�\0\0��\0 |�\0�4NDظJ�y�^�,�qW�UUU�S�\0@V�F���ѣG��.!�\0Y	�ξ�;v�w�\0�Z��k�k�YW�W\0 ��c����\0@9��cf]^��PUU5� ���� �\0Y���f]^�r��W\0�PI��ڿ��-[�$�֭K���U���!ٸqcWZ�t��\n\0\\����)9y�d��ѡ2T---IcccW\Zd��T�\0HŌ���\0[__ߡS�W\0 K��lW,#Щ�+\0��`$ \n��\0PQ�����m�\'�\rr?�ǄK�Ux\02^�|4����Ɏ��Q�X<\'`\n��+\0���z���^�5_G��0�W�\0�Nx�r�_�\r��)�\n�\0@f���\'�\r��)�\n�\0��W�\0hx�����)�\n�\0@f���M��\r��)�\n�\0@f�k�ѝɮ��d },�0�W�\0�Lx����{��xL�^�W\0 [����d��U�����s��*�\0��q�֞M�w�k<�-�Ux\0�7��?�߻>��nv��5_�x�YX�Ux\0J^�6�jVx^�̄�k�m��,��)�\n�\0@�����|	�«�\n\0�,�*�Ux\0�W%�\n�\0��*�\"���W�\0^��*�\0«��\n\0«\ZΊ0�J[F\0^��W\0��\r��_��*���+\0��:��z�ǆ�y�\0@x^�W\0\0�Ux\0^�W�\0@x^�W\0\0�Ux\0^m�%�\0�Jx\0^�W\0\0�U	�\0\0«^\0�W�\0@xU�+\0��W\0\0�Ux\0^��\n\0 �*�\0@x^\0�W%�\0��+\0\0«�\n\0 �*�\0`��[�N@^\0�CSSS�ɓ\'�Č֑#G��C�\0�֯_����Ʈo��FX�`pmhh����\n\0pY\Z����׷���*S�!�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0T��B�׉���\0\0\0\0IEND�B`�',1),('22',1,'bpmn/SalaryAdjust.bpmn','21','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:activiti=\"http://activiti.org/bpmn\"\n	xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\"\n	xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\"\n	expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.activiti.org/test\">\n\n	<process id=\"SalaryAdjust\" name=\"薪资调整\">\n		<startEvent id=\"startevent1\" name=\"Start\"></startEvent>\n		<userTask id=\"usertask1\" name=\"填写调整申请\"></userTask>\n		<userTask id=\"usertask2\" name=\"总监审批\"\n			activiti:candidateGroups=\"director\"></userTask>\n		<userTask id=\"usertask3\" name=\"人事审批\"\n			activiti:candidateGroups=\"hr\"></userTask>\n		<userTask id=\"usertask4\" name=\"老板审批\"\n			activiti:candidateGroups=\"boss\"></userTask>\n		<endEvent id=\"endevent1\" name=\"End\"></endEvent>\n		<callActivity id=\"callactivity1\" name=\"系统记录薪资\"\n			calledElement=\"CountSalary\"></callActivity>\n		<sequenceFlow id=\"flow1\" name=\"\" sourceRef=\"startevent1\"\n			targetRef=\"usertask1\"></sequenceFlow>\n		<sequenceFlow id=\"flow2\" name=\"\" sourceRef=\"usertask1\"\n			targetRef=\"usertask2\"></sequenceFlow>\n		<sequenceFlow id=\"flow3\" name=\"\" sourceRef=\"usertask2\"\n			targetRef=\"usertask3\"></sequenceFlow>\n		<sequenceFlow id=\"flow7\" name=\"\" sourceRef=\"usertask3\"\n			targetRef=\"callactivity1\"></sequenceFlow>\n		<sequenceFlow id=\"flow8\" name=\"\" sourceRef=\"callactivity1\"\n			targetRef=\"usertask4\"></sequenceFlow>\n		<exclusiveGateway id=\"exclusivegateway1\" name=\"Exclusive Gateway\"></exclusiveGateway>\n		<sequenceFlow id=\"flow9\" name=\"\" sourceRef=\"usertask4\"\n			targetRef=\"exclusivegateway1\"></sequenceFlow>\n		<sequenceFlow id=\"flow10\" name=\"\" sourceRef=\"exclusivegateway1\"\n			targetRef=\"endevent1\">\n			<conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[\n    			${pass == true}\n			]]></conditionExpression>\n		</sequenceFlow>\n		<serviceTask id=\"servicetask1\" name=\"取消调整\"\n			activiti:expression=\"${processService.cancelAdjust(execution)}\"></serviceTask>\n		<sequenceFlow id=\"flow11\" name=\"\" sourceRef=\"exclusivegateway1\"\n			targetRef=\"servicetask1\">\n			<conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[\n    			${pass == false}\n			]]></conditionExpression>\n		</sequenceFlow>\n		<sequenceFlow id=\"flow12\" name=\"\" sourceRef=\"servicetask1\"\n			targetRef=\"endevent1\"></sequenceFlow>\n	</process>\n	<bpmndi:BPMNDiagram id=\"BPMNDiagram_SalaryAdjust\">\n		<bpmndi:BPMNPlane bpmnElement=\"SalaryAdjust\"\n			id=\"BPMNPlane_SalaryAdjust\">\n			<bpmndi:BPMNShape bpmnElement=\"startevent1\"\n				id=\"BPMNShape_startevent1\">\n				<omgdc:Bounds height=\"35\" width=\"35\" x=\"180\" y=\"200\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"usertask1\" id=\"BPMNShape_usertask1\">\n				<omgdc:Bounds height=\"55\" width=\"105\" x=\"250\" y=\"190\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"usertask2\" id=\"BPMNShape_usertask2\">\n				<omgdc:Bounds height=\"55\" width=\"105\" x=\"400\" y=\"190\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"usertask3\" id=\"BPMNShape_usertask3\">\n				<omgdc:Bounds height=\"55\" width=\"105\" x=\"400\" y=\"280\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"usertask4\" id=\"BPMNShape_usertask4\">\n				<omgdc:Bounds height=\"55\" width=\"105\" x=\"560\" y=\"190\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"endevent1\" id=\"BPMNShape_endevent1\">\n				<omgdc:Bounds height=\"35\" width=\"35\" x=\"890\" y=\"200\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"callactivity1\"\n				id=\"BPMNShape_callactivity1\">\n				<omgdc:Bounds height=\"55\" width=\"105\" x=\"560\" y=\"280\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"exclusivegateway1\"\n				id=\"BPMNShape_exclusivegateway1\">\n				<omgdc:Bounds height=\"40\" width=\"40\" x=\"730\" y=\"197\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"servicetask1\"\n				id=\"BPMNShape_servicetask1\">\n				<omgdc:Bounds height=\"55\" width=\"105\" x=\"780\" y=\"120\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNEdge bpmnElement=\"flow1\" id=\"BPMNEdge_flow1\">\n				<omgdi:waypoint x=\"215\" y=\"217\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"250\" y=\"217\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow2\" id=\"BPMNEdge_flow2\">\n				<omgdi:waypoint x=\"355\" y=\"217\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"400\" y=\"217\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow3\" id=\"BPMNEdge_flow3\">\n				<omgdi:waypoint x=\"452\" y=\"245\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"452\" y=\"280\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow7\" id=\"BPMNEdge_flow7\">\n				<omgdi:waypoint x=\"505\" y=\"307\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"560\" y=\"307\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow8\" id=\"BPMNEdge_flow8\">\n				<omgdi:waypoint x=\"612\" y=\"280\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"612\" y=\"245\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow9\" id=\"BPMNEdge_flow9\">\n				<omgdi:waypoint x=\"665\" y=\"217\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"730\" y=\"217\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow10\" id=\"BPMNEdge_flow10\">\n				<omgdi:waypoint x=\"770\" y=\"217\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"890\" y=\"217\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow11\" id=\"BPMNEdge_flow11\">\n				<omgdi:waypoint x=\"750\" y=\"197\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"750\" y=\"147\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"780\" y=\"147\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow12\" id=\"BPMNEdge_flow12\">\n				<omgdi:waypoint x=\"885\" y=\"147\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"907\" y=\"147\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"907\" y=\"200\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n		</bpmndi:BPMNPlane>\n	</bpmndi:BPMNDiagram>\n</definitions>',0),('23',1,'bpmn/SalaryAdjust.SalaryAdjust.png','21','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0�\0\0Y\0\0\0dY0\0\0\ZtIDATx���Ml����qk���z̭��z���[O��b2�T!QJ��\"�RH�[�T�6U�U]�J6-� Ѵٲ���Ka��)\r��\rƮK�6؀���w=�x�����x���\n����l��</��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0PDEk���>9u�T���uttX)X���щ\'��uД\0\0u/�iooo444MNNZ)Z���QOO�t��&\0\0�kሩ0Mw�vttL�T\0\0���SyE`�W8�פ\0\0u-��\0�\0\0\0�&N��m,z��{3+�Z8�S\0\0������d4r����>���8\r��}|�������BR�\0\0T6NC��~�/�Ӈ�E�߿\Z�|p-z����8\r�����������?G7��8\0\0�`����x���ss1����_g�O�zKL�S\0\0���iXG�Xv������8\0\0�|��Sys�퍳���q���3+�:|,������\0\0�rq\Z��nx��i����˿5�w��\0\0\0�ӅN�\rGK?/|l����\0\0@��S\0\0���N��\0\0\0���?n�4��\"����\0\0��qz����J���/$�)\0\0@e��7ǣ��[v�n�l4�鸘�\0\0\0��������K3�����W��~0�\Z����>��߿:����(�31!&�)\0\0@��4��7�q��pã\\��_�>��[���8\0\0�N�.t�\\��+�8\0\0H$N-q\n\0\0P�G}t$��n��\0\0 �8�f�H&��(N�)\0\0@�q�[�I��\0\0��q:w$5?Rũ8\0\0H\"N玤��}ũ8\0\0(%&���i�W5__y\0\0�qZ���d2{���ׄ���{�T�\0\0I��(�Is���y�Z=.N\0\0qZ�8�f�m�Q�Z�t��U�qq\n\0\0��������Sq*N\0�ԅ�8�\0\0\0�T��S\0\0@��Sq\n\0\0 Nũ8\0\0ĩ���V2\0\0\0���\0\0�8��\0\0@�Z�\0\0��T�\0\0�SK�\0\0�T��S\0\0\0qj�S\0\0@��Sq\n\0\0 N-q\n\0\0�Sq*N\0\0ĩ%N\0\0q*N�)\0\0�8��)\0\0 Nũ8\0\0��8\0\0�iWW�\0�\0\0\0ɆBoo���АL������8\0\0�:N�������3}��u1��0����vq\n\0\0�u�q�������Z�Z��\nSq\n\0\0�\0\0 ��\0\0B3\0\00s\0\0�P��\0\0B�\0\0 0s\0\0�P\03\0\0�\0\0 ��\0\0B3\0\00s\0\0�P��\0\0B�PQ������ԩSQWWW���a�`uvvF\'N����Ase�+�g�\n$<_�aƖXc�)�,a���\r\r\rE���V����p���3o��͕e�̟�C���|�.��Lf�g\n(K8�`��\\GGǤ��̕�3�S���E�t���y�g	(K8��f)�+�g�,se��┄g����l6���66J6q��\\��f�?q\n˘���=s���&n��kQ߻?�.t�Y���c6Y6q��\\�?���S\Zf�Z]k\n$���1���3��_o�����c6Z6q��\\�?���S\Zf֮:j\n$����¯���V���m�l�̕�2��K���8����2��Ƽ85s@m7q����n��c6Z6q��\\�?��%f{���uf��N���rמ:j\n�|w�cO�M\\x�F�&�\\�+�g��D�4��(֔@��2������8F��f�7��/�S�Tx+��s.ƿ~5^_�A�ڵ롗_~����?�{��M�6E�֭��\"|�\'��۷O�۷�v�y|�;���8�&�\\�+�g���t��CI֮]�����R�h��ÑU(Á��gϞ��ׯ��y�護ފΝ;7�f���ߏrFFF��/Fǎ���ۣ���������p9��p�b��𘍖M��2W��25�{�\0�=�z@J6{GޱFi�GS=�P�-[����O?}{�ƍ��Çg�w�ލN�<9��6m��������t�Ţ��𘍖M��2W��25ӥ��TV��\n3�=���6�G�p�Bt�ڵ�Ν;s{�p��?��92�y���:�9_���<��c�E���j4>>���wߍ����_���l6��z�č�����S�⏅�l�l�̕�2�����M�-��iPa�:{=�\\Pnذ!z���g�a?�>ܲeK���N���-�m(b�Ν|�߈��?D�t�֭襗^\n_��y䑇W�&.�����6q�c6Y6q��\\�?���4L����	T��i�7�C2�\r���#\\w���y�m��t��uX L7o�\\����СC���맿�����MLD�~w��S�⏅�l�l�̕�2��Ke�V��S�q:�i8}7�^+�\Z��m�Vx�,BN8�71�f�������#�Km�FoD��Q�k��c�sl�l�̕�2�����n~T�?�:Rx���ӧ��ר��Q󏠶��|�+@�7?\nט���{Q���g?��nݺki��o�M��Dt�Rw���o���V���6�ę+se�,qZ�0��)�������GL�)�<�瞛����=T�4��;w�	7?��o}�[���հ�[ꨂ�\r6q��\\�?��U]ᵢ���������5�̈����1�䩼�ݗ%�84���3^	\ZVx��v1��+�Jηoii�N��-��[�Q�Ŏ6�x�ę+se�,qZ�0ݛ��W4���j��\'P�ڵk��ߕ�ܛ�\"܈4���l6�E�\riϞ=��{0%��矟���}��\r\\n�x�ę+se�,qZ�0\r~2�Q	�������]������`.����Z{{{~������ڵ����G###������T��4]{�ܷ\\�l�̕�2����b��Ph.���|נ6�p_.�ۼ����>��y���c�=䕡�<x�T8�>iO>��d6��dg�S�\\�?�W�G�FV�s~��-78K\rY��6���1��\\�;�&e˖-�7Gj���P���?���o\'�/��­Z�ڻ��6q6q��\\�S��U��dn�=G��e����R�Yj������Am��������y�7��Ƶ{��s��%��O����8-?m�l�̕���������\Z^�/�J=��X�~f�a:�Ujr�oC�_؇��x�b�{�����\reӦM��S_hpp�~x_���p����3W�J�Z毪�\'�6�|�\\�5��daZ��h��_��}��w�-t�ʕy�y�գ���k��M������&�&�\\�+qj���|���K��3O�=R�P������\Z�:����}�Ν���w�ޝ���գ�X�\"�8����&�&�\\�+qj�z-�{I]�/�˹�,�:��,p�tr���8��Q��4��)����1�egg�ĩ8��_M�o,����{;������)U�?GN!�r����pRל.��1�M\\����qGN�9Wi�;q��qj�\Z2N�t�t�)5�?לB\n�ڵk���[o�Ex3-?����>����i:�*�s\'ĩ�k�8\r��X$J�9R�n��5��)����ѣiy��w���Q���z�+q ̟�K���bGJ�=bY��9mm�>�\r3��M����w޾�W����K/���s�%��7o��7�[���Q���z�+q ̟�[��:r���,5Psa��%h---sQ��֖؞x۶msq\Z�-ڽ24��[�>�կ~5\ZO�=N��0�6l��Y�8qZϛ8q ̟��+R�j������\rhݺu_�Ea�a�[���t6N?��ر�nOOObq��/��_|m�ĩ8����?�GPO��IS��.�?.���ƴA�_wz�ȑ��<����\"4��;w�h�֭���L8b���2���&N��Sq ̟�c�@ͿIR~h�r��b����4��S{�;Z��-ef�����xEhX��Tooo��t���w�x�����V2�M��C��?�~������qS�oS���}U��������[o�U�=�}��^�j�����ݸq�f_�gΜ����r7��~�&����2�O��0P˵�)�4�����H��\\�=qx��kM׮]�o^	\ZޓO>�����&��^�zu�t���o�M�%N-se�,q�P�V:t�q �B񩧞��CO�<9�t�x��+\0M?��k_�ڽ�^{��a:44��{?����&����2�8]�rO�u*/z�G�#q*��m�޽[�0���n�ń[V�_�~�Zw(GLC��_|�l�,qj�+�g��\nj�G>�������5��pM���HEO�-8b:��K� q�ιq���W��p��t������ę+s%N-��zj�SyY�x�ږ-h8�y��������λ�T���[��8R����^�|�췋	w�\r7?J�5�6q6q�����k�@m���6O���q<N��d[[[t��Œ��W�\\�yӂ��3��\nSX~��G�ԁ&���J:�:888���/�����sa5}����ę+s%N-��,u\ri��{�/�y� *�o~�ѡC���v�ᮾ��R�?C������v��Q�n~+�2���	_�O<��������������n�m}GFF��/��/��­͛7OĿ/���b8M�&β�3W���Y��Au*/���*<���u���@���gCu8^����/�pW��x��zˆ\r>kg�ę+se�,�p�\nS*&t�����7K*a]�Ƴ���ę+K�z��_��aJ5��0�ף�3{���mF�u6����x�\0�8�8se��g�\ZS��4j�v1\0��Y6q��\\�?��%�!O\06q�M��2W��2\0�M�M���ā�3\0�M�eg�̕���\0P���.%�8se�|_��\0����ީ��!���������&n�\\Y����?\0��uww���g����6M)��uvvދW���̕�3\0@݋7	{;::��iVV���j����\\�7\Z7W�/�u��!�\0\0�]��	��`�����5�\r\0\0┚�d2��ͮݞ\0\0��$��j^��yF\0\0@$�Sj=s�ya:�2��^�\0\0�S���\r�i8z��S\0\0�P�yk] LgV6�m�\0�8�Z��p�8�רg\0\0�)T{�Z	Sמ\0�8�����Rq�ν\0\0 N��\0\0�\0�\0\0�0\0\0�8��\0\0�\0�\0\0 0\0\0�8\0�\0\0��\0\0 ��\0\0�\0�\0\0�0\0\0�8��\0\0�\0�\0\0 0\0\0�8\0�\0\0�$C,��<S�S\0\0��!кT�f2���)�)\0\0P�^$NG����x��\0\0@�c����l6��B�\0\0�\n���=s�q\n\0\0�2Z]k�8\0\0�W5E�\0\0��d2��t�gq\n\0\0$3מ:j�8\0\0��Vq�:tvvn�׽�����V��:��3}��������\0���(Z����ɩS�������Ba��8�\'NL��`��z|��,Nsk�wK\0\0�*�iooo444MNNZ)Z���QOO�tq��8{�bu-�-\0��p�T��;P�0���8�Z�s�S\0\0j&��k��@��8\0��	q*N-q\n\0���ӱO�E}��4�йof�_�����Sq*N\0�&q:zc :��g����6o����l�ũ8�\0\0P�8��¯����M�8��\0\0�������ix�&^��Sq\n\0\0U���{��ix�&^��Sq\n\0\0�T��SK�\0P�q\Z��[,N�c6��T��S\0\0�z�^:�b�8\r��ċSq*N\0��q:2p.:��O�?����T�\0@��4������4|�^��Sq\n\0\0��Ӊ����>xJo���M�8��\0\0�\Z��7�O���5���96��T��S\0\0�|�NLD�.uG��v�0ͭ�9�sE��T�\0@��t������Sq*N\0��q�����E����T�\0@�q��0�-�zq*N�)\0\0���8��8\0@�Z���\0\0�SK����G�f��ĩ8\0\0q*N���hv�d2���T�\0�8�I�in\rI��\0\0ĩ8�u��I�E�8�\0\0 N�iRq:w$U��S\0\0��h-#�V���\0\0VE���y�Z=����-�c�Lfoss��4��Z\r�)N\0�����>V���iE�t.J�g/�8Mr�V�|�S\0\0ĩ8��8�f�m�Q*N�)\0\0�SqZ�8}�H�8�\0\0 N�i*gO��S\0\0��T��Sq\n\0�8��T��S\0\0Xq��dĩ���V2\0\0�SK��k�Z�\0\0qj�Sq*N\0@��Sqj�S\0\0ĩ%NWu�6�t�%N\0@��SqZ�;�V���)\0\0����tűY���)\0\0�Sq*Nũ8\0@�Z�T��S\0\0��T��Sq\n\0�8����ӦeޥW�\0�8��ԑSq\n\0�8�ĩ8�\0\0 Nũ8��\0\0qj�Sq*N\0@��SqZ�8���S\0\0\ZNWW�\0��tqZ��\0\0����ީ��!�����9�Iqj�zݼyS�\0P;������陾~��\ry\nô���^���q��?>�?V��\r�-\0��8~�ƛ�1�ԭ�z\r� ��w�k�j��)\0�z�K����)��}�4~���V\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�����3g()\0\0\0\0IEND�B`�',1),('26',1,'bpmn/Vacation.bpmn','25','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n	xmlns:activiti=\"http://activiti.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\"\n	xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\"\n	typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\"\n	targetNamespace=\"http://www.activiti.org/test\">\n	<process id=\"Vacation\" name=\"请假申请\" isExecutable=\"true\">\n		<startEvent id=\"startevent1\" name=\"Start\"></startEvent>\n		<userTask id=\"usertask1\" name=\"填写请假申请\"\n			activiti:candidateGroups=\"employee\"></userTask>\n		<userTask id=\"usertask2\" name=\"经理审批\"\n			activiti:candidateGroups=\"manager\"></userTask>\n		<userTask id=\"usertask3\" name=\"总监审批\"\n			activiti:candidateGroups=\"director\"></userTask>\n		<userTask id=\"usertask4\" name=\"人力资源审批\"\n			activiti:candidateGroups=\"hr\"></userTask>\n		<endEvent id=\"endevent1\" name=\"End\"></endEvent>\n		<exclusiveGateway id=\"exclusivegateway1\" name=\"Exclusive Gateway\"></exclusiveGateway>\n		<sequenceFlow id=\"flow1\" sourceRef=\"startevent1\"\n			targetRef=\"usertask1\"></sequenceFlow>\n		<sequenceFlow id=\"flow7\" sourceRef=\"usertask1\" targetRef=\"exclusivegateway1\"></sequenceFlow>\n		<sequenceFlow id=\"flow8\" name=\"小于等于3天\" sourceRef=\"exclusivegateway1\"\n			targetRef=\"usertask2\">\n			<conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${arg.days <= 3}]]></conditionExpression>\n		</sequenceFlow>\n		<sequenceFlow id=\"flow12\" name=\"大于3天\" sourceRef=\"exclusivegateway1\"\n			targetRef=\"usertask3\">\n			<conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${arg.days > 3}]]></conditionExpression>\n		</sequenceFlow>\n		<sequenceFlow id=\"flow13\" sourceRef=\"usertask2\"\n			targetRef=\"usertask4\"></sequenceFlow>\n		<sequenceFlow id=\"flow14\" sourceRef=\"usertask3\"\n			targetRef=\"usertask4\"></sequenceFlow>\n		<sequenceFlow id=\"flow15\" sourceRef=\"usertask4\"\n			targetRef=\"endevent1\"></sequenceFlow>\n	</process>\n	<bpmndi:BPMNDiagram id=\"BPMNDiagram_Vacation\">\n		<bpmndi:BPMNPlane bpmnElement=\"Vacation\" id=\"BPMNPlane_Vacation\">\n			<bpmndi:BPMNShape bpmnElement=\"startevent1\"\n				id=\"BPMNShape_startevent1\">\n				<omgdc:Bounds height=\"35.0\" width=\"35.0\" x=\"60.0\" y=\"201.0\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"usertask1\" id=\"BPMNShape_usertask1\">\n				<omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"150.0\" y=\"191.0\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"usertask2\" id=\"BPMNShape_usertask2\">\n				<omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"430.0\" y=\"101.0\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"usertask3\" id=\"BPMNShape_usertask3\">\n				<omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"430.0\" y=\"191.0\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"usertask4\" id=\"BPMNShape_usertask4\">\n				<omgdc:Bounds height=\"55.0\" width=\"105.0\" x=\"567.0\" y=\"144.0\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"endevent1\" id=\"BPMNShape_endevent1\">\n				<omgdc:Bounds height=\"35.0\" width=\"35.0\" x=\"730.0\" y=\"154.0\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNShape bpmnElement=\"exclusivegateway1\"\n				id=\"BPMNShape_exclusivegateway1\">\n				<omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"306.0\" y=\"198.0\"></omgdc:Bounds>\n			</bpmndi:BPMNShape>\n			<bpmndi:BPMNEdge bpmnElement=\"flow1\" id=\"BPMNEdge_flow1\">\n				<omgdi:waypoint x=\"95.0\" y=\"218.0\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"150.0\" y=\"218.0\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow7\" id=\"BPMNEdge_flow7\">\n				<omgdi:waypoint x=\"255.0\" y=\"218.0\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"306.0\" y=\"218.0\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow8\" id=\"BPMNEdge_flow8\">\n				<omgdi:waypoint x=\"326.0\" y=\"198.0\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"326.0\" y=\"128.0\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"430.0\" y=\"128.0\"></omgdi:waypoint>\n				<bpmndi:BPMNLabel>\n					<omgdc:Bounds height=\"14.0\" width=\"66.0\" x=\"320.0\" y=\"111.0\"></omgdc:Bounds>\n				</bpmndi:BPMNLabel>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow12\" id=\"BPMNEdge_flow12\">\n				<omgdi:waypoint x=\"346.0\" y=\"218.0\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"430.0\" y=\"218.0\"></omgdi:waypoint>\n				<bpmndi:BPMNLabel>\n					<omgdc:Bounds height=\"14.0\" width=\"42.0\" x=\"359.0\" y=\"225.0\"></omgdc:Bounds>\n				</bpmndi:BPMNLabel>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow13\" id=\"BPMNEdge_flow13\">\n				<omgdi:waypoint x=\"535.0\" y=\"128.0\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"618.0\" y=\"128.0\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"619.0\" y=\"144.0\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow14\" id=\"BPMNEdge_flow14\">\n				<omgdi:waypoint x=\"535.0\" y=\"218.0\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"618.0\" y=\"218.0\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"619.0\" y=\"199.0\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n			<bpmndi:BPMNEdge bpmnElement=\"flow15\" id=\"BPMNEdge_flow15\">\n				<omgdi:waypoint x=\"672.0\" y=\"171.0\"></omgdi:waypoint>\n				<omgdi:waypoint x=\"730.0\" y=\"171.0\"></omgdi:waypoint>\n			</bpmndi:BPMNEdge>\n		</bpmndi:BPMNPlane>\n	</bpmndi:BPMNDiagram>\n</definitions>',0),('27',1,'bpmn/Vacation.Vacation.png','25','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0\0\0\0\0��\n�\0\0�IDATx���Ml��pk��ܢ=�c�=�=���CN�yW@D]�R�[4��VAJ(}U�m���FE��ťfC�\n�-�IpX^\Z��6���<����=��?3�|>�O6�����<�y�/uu\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�.I�%]]]utt$�O�NN�:���ZZZ�3gΌ�:�]\n\0@Y�`��ޞܼy3PUT===I[[�H\n�S\0H]\\1�; �:uj�;\0���C�L«��aFީ\0\0�.N<M��\0\0(:�������O�Ζݣ�����\0\0�P8�s�;������l\ZW��^8\0\0�F��G���ru��-x�\0\0�Z	{�;�A�f/\0\0P#����A�f/\0\0 �\0\0��Չ\n����^8\0\0�d�˭�TU��Q�$k6>3?y+�Q�?\'��gq�	�p\0\00e8��G�8���WC}>����\nWo�����^�|HQx,n3�\0\0�2�P���ק�|{D8�8���?�>)��Lޅ\0��\r��N��C�pP�p�ߟ\\��ɇ���6x�\0\0�j�A�$Ɋ�l����;{��9q��$\0\0U6���\n���[������`�ᠿ?�~�5�����\\����ZE\0\0�M�+y��B ��m��\Z��d1?\'�n��*�p\0\0@���bV�[E0�\0\0X$�`�� W&��\0\0�$(�\0\0�Ed����l�Y8\0\0����d2���\0\0\0� W=S�$�\0\0��$��@8\0\0�v�����x��p Ԓ�;w>d/\0@uORU�����{��% \0@�Á�PU��n&�ٵt��%�yV�����ȪU��\'\0@8��p0.�Ts8��)�\\ۅ��\'���f���\'\0@8��pp\'L��O%L�X�ۅ�E�{q���1cO\0�pPk�}ʕ�@8�e�w�V���	\0���z\\I�H<�(�\",[��q{\0���`������\'!�\n_?u���C@x��\0�\0�@8X���@�?C�]�4��\\��\0@8@8j���p�����\0@8`���:�2�߃�X5�g�\0�p�	J8(�x�q�U���;\0  5&�[0!555=l�\0�p�p �^8x,���p�f�\0�p�p Ԩl6��\\8x�駟�G\0@8@8jT�[x�G��L��\0�\0�@8�u\r\r\r/�Ë�	\0��9H�dIWW�G��ӧG�?����Ғ�9sf$��\0�\0�@8(���ۓ�7oz=��zzz������f\0�A�⊁`P�!�Gt3\0��� u�P\"���\02���\0�@8P&~�{��������O�Ζݣ���y\r�\0�UC��έ���ow$�i\\���6��p\0\0p�j$|���I� W�:��:\n\0 �V�����N�p�y�\0\0W�1�+E8�|jg�p�y��r�d2��z9�A�d��[��P�r_��\\	߿�s�\Z�pP���ۇ]þz�ڵkT�\Z�p�����o����A`u\'��.]�ĞjRkk��Voܸa�U������~��~[L8�W\'*�6��pP��fe��sk �&!\0���&�����n�`����J�b��ճ�\n����^8Hy��8�ollL��ߟ=z4���L�_��|��gI4888z����{/9v����V�\\9UH�	�F	\0�\0�E8���\\���)\n��m&��A\Z���#c�<��755%?��OG\'����ח?~<Y�~�����dF¿�^\'\0���h��?�>)��Lޅ���A_>͟��رct�`>����\'N��<���#!$�\r\0��	����?�|HQx,n3�R�V��Cqb_*���ɦM�&�\"��\0�f�;�{g<� ns�d���ʸsΝ;��!���G�_AhhhxJW\0@8�b������/\'�/r��kA8(���r�A�������w�x�@8\0�����AZ���^�9�<���۷o\'k֬�?���\0 �p0VŬL��`B/���\r�\\�h�\'�ƻ�;��\"wT@8���\\��sO>�M���J�������@8\0�@	��Ͽ��l�cP\n������Z��Q@8\0�@	�/�&��\nB����l6�_�\0@8P�Aiǉ�0�n��9��\nE�y��7�� �p���4ǉ��\r��S=\'��gW�\\�X8��T����\0�J8H\'�g�JBxl(���W)���?w�@8\0�@	醃���BB����ŕo����!\0��pP�p�`%!�ϕ&\0 ���\"&׋��\0@\r����OYe����ǉu7���Z�t��\0�p0�cվ]8�s8x\nr�q�\"\0�\0���\nw���CA�s.V�}⿝����C\0 �AiǉI+544��;$oڴ)�&ht\0�\0��@8(����\'r���}r��튞o0�!\0�����;8v�X����#G���U�@8\0�@8*$�Т���^Ҵ��{t�\"o�\"�;\0 ���K�V��%M?�MЏ?^�p�{���U��u\0�\0�����z?���?��z08q�ĸs\r����Sg\0@8P�Au�+��&�6lH���RgϞw8Q���\n\0�J8�˖-{<�-ù	��}�����T�ASS����@8�Y&�Yj$7q�������P�	+=�l�@8\0��\\8�B�n����O�ϝ;7������1\0�@8�����a�ɟ��;(_�re�78��1��Z0z(�`\0 \0p�@444<ƚ�	���+_�J��o$���W5ʝ���0W�=�lٲeb p�1�p\0��B?��M��U�9��.W\n \0p��566>Ɲ����gQW��@8\0��`�ijjzx�|�w�	�;�f��R���.� �r���5�$I�tuu}��ё�>}z�	��WKKKr�̙�PG�K��E-��\"@��w<���͛�`�UOOO���6�ީ��c����O���=���<�*�/j1��@8\0�L\\���4f�\0�E�1И5f�\0�E�Q� `v���?�\']��t����}|L�Ԙ������PC���[�����H.�fӸ���m���,���/s���>켔�k׮}�70xO��:=i��յη4P�R�����v���fimm�V�jҍ7�UZZZ�b�\'����N��;n�D��\n�j$ԅ�����E-��&�����{PT]\r`�.��Yp����A��A.ĕ�aAQ�K%e2���l���j�m۶G>��={��m߾}���9ill|p�g�}6ټy���ݻ���������ko���3=����ԅP�Zn��O�#P!{��}~�Ν�V�X��ر#9~�xr�ҥћ�\r\r%9���ɕ+W��\'O&HV�\\��P���Z�t����G�zH��;n3�\Z��d� ��9���_ʦ����\n�s� ��\\�W��֯_���=�ܽիW\'G�������`r����@���<�����u�졂�w�f�5x�1�4񷂠�(���B h���\ZY�jգ��I��\r�t�k������%�u���d͚5ɗ����l�������\\������cq�����u�[����_��$B4!�V~a�@lݺ��_��w�}7)�۷o\'���J���4�lٲ�\rޓ��z}��3�\Z��v����E�/�	A��T� ���Í�!H9�[�n�|�����Ɋ+F�~��\'\r�y�ߟ\\���K�ᱸ�\0k�`P��G�_((�ɬ�*��=��x(Q\\1H3���W���fVf\Z��J�;{��1�q���\Z�S0�����{�_���f����z�%HA<�8�c��?�9)����gC����k�JF��������/\'�/8p�*>\'>ק|��RdAQ�KI�9B&����*V�[Pb[�n�,�|\\n_��׆kᄢ��>��)��;E���P?�:�9���_R�@GCC�����ƪ9~�g���}��JKqU�����N�/�H����]̧y�}�g�5x���8���P���bB���%�&�.���=)�78;v�XR)������\'�6x�u�Ε��]�`P7���W���`��W�;AQ�AZ+�=)ٶmۣ��ǳ��Y�W�G��^jP�STh�>�D��P�󝃠�(� �p�q6��oO@J�9��`\\ik׮��\r\Z���{�A�w��\'3�|\\��A�!Fex�����~/�7�F{R�gϞ���z���ॗ^��-2x���~{p�x��\"��	�L�����\nBz�������������g�	H���ۇ/]�T�pp�ܹ{�Z�oe�.�������l�)\0�c0��r! ��z�/�K-	�\r\r\rO��������l&�|��P�\r��[�g�~{N�x��������<��|�?�����������P��\' %������PR\r�g�V�9���ӱ��~R?U@�O0���P��[�_j��b�_�¿����S-Y80x/�*�\\��$��<��M�b00��|\\X,������RK5�(���r�XK8��^�a�n���.<�Չ�,�ƽ����RcHS��s��ӳX�9�����o�l7xO�~�\n���;�`�)_�j��?�`�ضm�HgggU\\�(|�\Z����{�ڷ��|�݉7*�Ɓ����Պ��]����p\0,\Z�>\'N�����c���i�oӭ�����s���}R}���\0�d^y�����x8X�n]�\\�7x�A*f��>�;$��m�#\0%�q��ǟy晤�����8� ijjz��-�)��0�	����@8\0�-[����U,:t�/��\\1x�A��\n��C|~P7�C��\n�N�w�c ��mݺ��ƍ+rIӸb���0������[8��ORΟ���$�B?�r�p \0]ss�p{{{����={>[�|�E��K�ֹ�i9M<�(N�_����I\'��|�0��/�&SU�ۣ�v�l8|f0>~�V�bNq)S��)k֬y.Tr�֭��.644f��G�e�x@���Y*y8��G�8����WC}>�����_��Ԝ�k�^��w�[�Ë>����É���7�¾5x�y@(�\r�JB�yh��S��=\"(���x9�/~��_��T�A�#sSSS�#�/ke�\Z�\r�Ul���z(Q��A�S�;�����-(�`\Z�L�+V�;v,���/_�QK���m�^ a�������R��(��_?�6,(�`��A! ���?N���ZZ10x���\ZT�C�J6���Њ���[������@�/\0E�+!$\\�W1���}��xU�x�q��c`�6x/򀰲�78��Պb0�` >�����i����������	����{��wuu\r���Ǉ��鬅��\rދ�L��J������_�Z\'�˗/o5������wZ[[�>���q�5���>w�ܽ�^z���u����%��ǋ�go��\"Th�����/\0U,L�W���P�C%�\na`8|����������1���{��@Q�\0o���PwA0�_������M<� �+��J�_�\0���]�����\0`�6x����\0�o�_������\r���_\0H��ӧ\r�o�_�\0��koo�y�A�J�ڵk��{�;�E�/\0�����[mmm#7n�0XV�����r?��T���\0Pap�u�ԩ�qyYUU\r��_��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���N���7ڲL\0\0\0\0IEND�B`�',1);
/*!40000 ALTER TABLE `ACT_GE_BYTEARRAY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_GE_PROPERTY`
--

DROP TABLE IF EXISTS `ACT_GE_PROPERTY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_GE_PROPERTY` (
  `NAME_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_GE_PROPERTY`
--

LOCK TABLES `ACT_GE_PROPERTY` WRITE;
/*!40000 ALTER TABLE `ACT_GE_PROPERTY` DISABLE KEYS */;
INSERT INTO `ACT_GE_PROPERTY` VALUES ('cfg.execution-related-entities-count','false',1),('next.dbid','2501',2),('schema.history','create(6.0.0.4)',1),('schema.version','6.0.0.4',1);
/*!40000 ALTER TABLE `ACT_GE_PROPERTY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_ACTINST`
--

DROP TABLE IF EXISTS `ACT_HI_ACTINST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_ACTINST` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin NOT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ACT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_ACT_INST_START` (`START_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_PROCINST` (`PROC_INST_ID_`,`ACT_ID_`),
  KEY `ACT_IDX_HI_ACT_INST_EXEC` (`EXECUTION_ID_`,`ACT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_ACTINST`
--

LOCK TABLES `ACT_HI_ACTINST` WRITE;
/*!40000 ALTER TABLE `ACT_HI_ACTINST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_ACTINST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_ATTACHMENT`
--

DROP TABLE IF EXISTS `ACT_HI_ATTACHMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_ATTACHMENT` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `URL_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CONTENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_ATTACHMENT`
--

LOCK TABLES `ACT_HI_ATTACHMENT` WRITE;
/*!40000 ALTER TABLE `ACT_HI_ATTACHMENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_ATTACHMENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_COMMENT`
--

DROP TABLE IF EXISTS `ACT_HI_COMMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_COMMENT` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime(3) NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MESSAGE_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `FULL_MSG_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_COMMENT`
--

LOCK TABLES `ACT_HI_COMMENT` WRITE;
/*!40000 ALTER TABLE `ACT_HI_COMMENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_COMMENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_DETAIL`
--

DROP TABLE IF EXISTS `ACT_HI_DETAIL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_DETAIL` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TIME_` datetime(3) NOT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_DETAIL_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_ACT_INST` (`ACT_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_TIME` (`TIME_`),
  KEY `ACT_IDX_HI_DETAIL_NAME` (`NAME_`),
  KEY `ACT_IDX_HI_DETAIL_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_DETAIL`
--

LOCK TABLES `ACT_HI_DETAIL` WRITE;
/*!40000 ALTER TABLE `ACT_HI_DETAIL` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_DETAIL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_IDENTITYLINK`
--

DROP TABLE IF EXISTS `ACT_HI_IDENTITYLINK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_IDENTITYLINK` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_TASK` (`TASK_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_IDENTITYLINK`
--

LOCK TABLES `ACT_HI_IDENTITYLINK` WRITE;
/*!40000 ALTER TABLE `ACT_HI_IDENTITYLINK` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_IDENTITYLINK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_PROCINST`
--

DROP TABLE IF EXISTS `ACT_HI_PROCINST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_PROCINST` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `END_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `PROC_INST_ID_` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PRO_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_PRO_I_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_PROCINST`
--

LOCK TABLES `ACT_HI_PROCINST` WRITE;
/*!40000 ALTER TABLE `ACT_HI_PROCINST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_PROCINST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_TASKINST`
--

DROP TABLE IF EXISTS `ACT_HI_TASKINST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_TASKINST` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `CLAIM_TIME_` datetime(3) DEFAULT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `DUE_DATE_` datetime(3) DEFAULT NULL,
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_TASK_INST_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_TASKINST`
--

LOCK TABLES `ACT_HI_TASKINST` WRITE;
/*!40000 ALTER TABLE `ACT_HI_TASKINST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_TASKINST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_VARINST`
--

DROP TABLE IF EXISTS `ACT_HI_VARINST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_VARINST` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` datetime(3) DEFAULT NULL,
  `LAST_UPDATED_TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_PROCVAR_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_NAME_TYPE` (`NAME_`,`VAR_TYPE_`),
  KEY `ACT_IDX_HI_PROCVAR_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_VARINST`
--

LOCK TABLES `ACT_HI_VARINST` WRITE;
/*!40000 ALTER TABLE `ACT_HI_VARINST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_VARINST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_ID_GROUP`
--

DROP TABLE IF EXISTS `ACT_ID_GROUP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_ID_GROUP` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_ID_GROUP`
--

LOCK TABLES `ACT_ID_GROUP` WRITE;
/*!40000 ALTER TABLE `ACT_ID_GROUP` DISABLE KEYS */;
INSERT INTO `ACT_ID_GROUP` VALUES ('boss',1,'老板组','boss'),('director',1,'总监组','director'),('employee',1,'员工组','employee'),('finance',1,'财务组','finance'),('hr',1,'人事组','hr'),('manager',1,'经理组','manager');
/*!40000 ALTER TABLE `ACT_ID_GROUP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_ID_INFO`
--

DROP TABLE IF EXISTS `ACT_ID_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_ID_INFO` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD_` longblob,
  `PARENT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_ID_INFO`
--

LOCK TABLES `ACT_ID_INFO` WRITE;
/*!40000 ALTER TABLE `ACT_ID_INFO` DISABLE KEYS */;
INSERT INTO `ACT_ID_INFO` VALUES ('1',1,'0372144c-a79a-4d6c-8f26-5ba5b63a2426','userinfo','age','30',NULL,NULL),('11',1,'1c8732b5-eb6e-448d-9447-e28b9e13954e','userinfo','age','30',NULL,NULL),('3',1,'c46768ba-942c-425c-9b64-fe7eff17ddba','userinfo','age','30',NULL,NULL),('5',1,'665d99be-e2ce-4a82-b07b-5bc091b1fb31','userinfo','age','30',NULL,NULL),('7',1,'2b81d40d-b5b0-48ee-9618-9bb5bc3075a4','userinfo','age','30',NULL,NULL),('9',1,'229b490b-3cd7-4fe2-8bd7-928a61806f75','userinfo','age','30',NULL,NULL);
/*!40000 ALTER TABLE `ACT_ID_INFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_ID_MEMBERSHIP`
--

DROP TABLE IF EXISTS `ACT_ID_MEMBERSHIP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_ID_MEMBERSHIP` (
  `USER_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`USER_ID_`,`GROUP_ID_`),
  KEY `ACT_FK_MEMB_GROUP` (`GROUP_ID_`),
  CONSTRAINT `ACT_FK_MEMB_GROUP` FOREIGN KEY (`GROUP_ID_`) REFERENCES `act_id_group` (`ID_`),
  CONSTRAINT `ACT_FK_MEMB_USER` FOREIGN KEY (`USER_ID_`) REFERENCES `act_id_user` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_ID_MEMBERSHIP`
--

LOCK TABLES `ACT_ID_MEMBERSHIP` WRITE;
/*!40000 ALTER TABLE `ACT_ID_MEMBERSHIP` DISABLE KEYS */;
INSERT INTO `ACT_ID_MEMBERSHIP` VALUES ('229b490b-3cd7-4fe2-8bd7-928a61806f75','boss'),('665d99be-e2ce-4a82-b07b-5bc091b1fb31','director'),('0372144c-a79a-4d6c-8f26-5ba5b63a2426','employee'),('1c8732b5-eb6e-448d-9447-e28b9e13954e','finance'),('2b81d40d-b5b0-48ee-9618-9bb5bc3075a4','hr'),('c46768ba-942c-425c-9b64-fe7eff17ddba','manager');
/*!40000 ALTER TABLE `ACT_ID_MEMBERSHIP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_ID_USER`
--

DROP TABLE IF EXISTS `ACT_ID_USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_ID_USER` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `FIRST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LAST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PWD_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PICTURE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_ID_USER`
--

LOCK TABLES `ACT_ID_USER` WRITE;
/*!40000 ALTER TABLE `ACT_ID_USER` DISABLE KEYS */;
INSERT INTO `ACT_ID_USER` VALUES ('0372144c-a79a-4d6c-8f26-5ba5b63a2426',1,NULL,'员工甲',NULL,'123456',NULL),('1c8732b5-eb6e-448d-9447-e28b9e13954e',1,NULL,'财务甲 ',NULL,'123456',NULL),('229b490b-3cd7-4fe2-8bd7-928a61806f75',1,NULL,'老板甲 ',NULL,'123456',NULL),('2b81d40d-b5b0-48ee-9618-9bb5bc3075a4',1,NULL,'人事甲 ',NULL,'123456',NULL),('665d99be-e2ce-4a82-b07b-5bc091b1fb31',1,NULL,'总监甲 ',NULL,'123456',NULL),('c46768ba-942c-425c-9b64-fe7eff17ddba',1,NULL,'经理甲 ',NULL,'123456',NULL);
/*!40000 ALTER TABLE `ACT_ID_USER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_PROCDEF_INFO`
--

DROP TABLE IF EXISTS `ACT_PROCDEF_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_PROCDEF_INFO` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `INFO_JSON_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_IDX_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_INFO_JSON_BA` (`INFO_JSON_ID_`),
  CONSTRAINT `ACT_FK_INFO_JSON_BA` FOREIGN KEY (`INFO_JSON_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_INFO_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_PROCDEF_INFO`
--

LOCK TABLES `ACT_PROCDEF_INFO` WRITE;
/*!40000 ALTER TABLE `ACT_PROCDEF_INFO` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_PROCDEF_INFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RE_DEPLOYMENT`
--

DROP TABLE IF EXISTS `ACT_RE_DEPLOYMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RE_DEPLOYMENT` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `DEPLOY_TIME_` timestamp(3) NULL DEFAULT NULL,
  `ENGINE_VERSION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RE_DEPLOYMENT`
--

LOCK TABLES `ACT_RE_DEPLOYMENT` WRITE;
/*!40000 ALTER TABLE `ACT_RE_DEPLOYMENT` DISABLE KEYS */;
INSERT INTO `ACT_RE_DEPLOYMENT` VALUES ('13',NULL,NULL,NULL,'','2017-07-28 01:42:39.660',NULL),('17',NULL,NULL,NULL,'','2017-07-28 01:42:40.412',NULL),('21',NULL,NULL,NULL,'','2017-07-28 01:42:40.738',NULL),('25',NULL,NULL,NULL,'','2017-07-28 01:42:41.082',NULL);
/*!40000 ALTER TABLE `ACT_RE_DEPLOYMENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RE_MODEL`
--

DROP TABLE IF EXISTS `ACT_RE_MODEL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RE_MODEL` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LAST_UPDATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `VERSION_` int(11) DEFAULT NULL,
  `META_INFO_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_EXTRA_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_MODEL_SOURCE` (`EDITOR_SOURCE_VALUE_ID_`),
  KEY `ACT_FK_MODEL_SOURCE_EXTRA` (`EDITOR_SOURCE_EXTRA_VALUE_ID_`),
  KEY `ACT_FK_MODEL_DEPLOYMENT` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_MODEL_DEPLOYMENT` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE` FOREIGN KEY (`EDITOR_SOURCE_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE_EXTRA` FOREIGN KEY (`EDITOR_SOURCE_EXTRA_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RE_MODEL`
--

LOCK TABLES `ACT_RE_MODEL` WRITE;
/*!40000 ALTER TABLE `ACT_RE_MODEL` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RE_MODEL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RE_PROCDEF`
--

DROP TABLE IF EXISTS `ACT_RE_PROCDEF`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RE_PROCDEF` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL,
  `HAS_GRAPHICAL_NOTATION_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `ENGINE_VERSION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`,`TENANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RE_PROCDEF`
--

LOCK TABLES `ACT_RE_PROCDEF` WRITE;
/*!40000 ALTER TABLE `ACT_RE_PROCDEF` DISABLE KEYS */;
INSERT INTO `ACT_RE_PROCDEF` VALUES ('CountSalary:1:16',1,'http://www.activiti.org/test','计算薪资','CountSalary',1,'13','bpmn/CountSalary.bpmn','bpmn/CountSalary.CountSalary.png',NULL,0,1,1,'',NULL),('ExpenseAccount:1:20',1,'http://www.activiti.org/test','报销申请','ExpenseAccount',1,'17','bpmn/ExpenseAccount.bpmn','bpmn/ExpenseAccount.ExpenseAccount.png',NULL,0,1,1,'',NULL),('SalaryAdjust:1:24',1,'http://www.activiti.org/test','薪资调整','SalaryAdjust',1,'21','bpmn/SalaryAdjust.bpmn','bpmn/SalaryAdjust.SalaryAdjust.png',NULL,0,1,1,'',NULL),('Vacation:1:28',1,'http://www.activiti.org/test','请假申请','Vacation',1,'25','bpmn/Vacation.bpmn','bpmn/Vacation.Vacation.png',NULL,0,1,1,'',NULL);
/*!40000 ALTER TABLE `ACT_RE_PROCDEF` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_DEADLETTER_JOB`
--

DROP TABLE IF EXISTS `ACT_RU_DEADLETTER_JOB`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_DEADLETTER_JOB` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_DEADLETTER_JOB`
--

LOCK TABLES `ACT_RU_DEADLETTER_JOB` WRITE;
/*!40000 ALTER TABLE `ACT_RU_DEADLETTER_JOB` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_DEADLETTER_JOB` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_EVENT_SUBSCR`
--

DROP TABLE IF EXISTS `ACT_RU_EVENT_SUBSCR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_EVENT_SUBSCR` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EVENT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EVENT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVITY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CONFIGURATION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EVENT_SUBSCR_CONFIG_` (`CONFIGURATION_`),
  KEY `ACT_FK_EVENT_EXEC` (`EXECUTION_ID_`),
  CONSTRAINT `ACT_FK_EVENT_EXEC` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_EVENT_SUBSCR`
--

LOCK TABLES `ACT_RU_EVENT_SUBSCR` WRITE;
/*!40000 ALTER TABLE `ACT_RU_EVENT_SUBSCR` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_EVENT_SUBSCR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_EXECUTION`
--

DROP TABLE IF EXISTS `ACT_RU_EXECUTION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_EXECUTION` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_EXEC_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ROOT_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `IS_ACTIVE_` tinyint(4) DEFAULT NULL,
  `IS_CONCURRENT_` tinyint(4) DEFAULT NULL,
  `IS_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_MI_ROOT_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `CACHED_ENT_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime(3) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
  `IS_COUNT_ENABLED_` tinyint(4) DEFAULT NULL,
  `EVT_SUBSCR_COUNT_` int(11) DEFAULT NULL,
  `TASK_COUNT_` int(11) DEFAULT NULL,
  `JOB_COUNT_` int(11) DEFAULT NULL,
  `TIMER_JOB_COUNT_` int(11) DEFAULT NULL,
  `SUSP_JOB_COUNT_` int(11) DEFAULT NULL,
  `DEADLETTER_JOB_COUNT_` int(11) DEFAULT NULL,
  `VAR_COUNT_` int(11) DEFAULT NULL,
  `ID_LINK_COUNT_` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`),
  KEY `ACT_IDC_EXEC_ROOT` (`ROOT_PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PARENT` (`PARENT_ID_`),
  KEY `ACT_FK_EXE_SUPER` (`SUPER_EXEC_`),
  KEY `ACT_FK_EXE_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_EXE_PARENT` FOREIGN KEY (`PARENT_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE,
  CONSTRAINT `ACT_FK_EXE_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ACT_FK_EXE_SUPER` FOREIGN KEY (`SUPER_EXEC_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_EXECUTION`
--

LOCK TABLES `ACT_RU_EXECUTION` WRITE;
/*!40000 ALTER TABLE `ACT_RU_EXECUTION` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_EXECUTION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_IDENTITYLINK`
--

DROP TABLE IF EXISTS `ACT_RU_IDENTITYLINK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_IDENTITYLINK` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
  KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TSKASS_TASK` (`TASK_ID_`),
  KEY `ACT_FK_IDL_PROCINST` (`PROC_INST_ID_`),
  CONSTRAINT `ACT_FK_ATHRZ_PROCEDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_IDL_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TSKASS_TASK` FOREIGN KEY (`TASK_ID_`) REFERENCES `act_ru_task` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_IDENTITYLINK`
--

LOCK TABLES `ACT_RU_IDENTITYLINK` WRITE;
/*!40000 ALTER TABLE `ACT_RU_IDENTITYLINK` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_IDENTITYLINK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_JOB`
--

DROP TABLE IF EXISTS `ACT_RU_JOB`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_JOB` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_JOB`
--

LOCK TABLES `ACT_RU_JOB` WRITE;
/*!40000 ALTER TABLE `ACT_RU_JOB` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_JOB` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_SUSPENDED_JOB`
--

DROP TABLE IF EXISTS `ACT_RU_SUSPENDED_JOB`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_SUSPENDED_JOB` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_SUSPENDED_JOB`
--

LOCK TABLES `ACT_RU_SUSPENDED_JOB` WRITE;
/*!40000 ALTER TABLE `ACT_RU_SUSPENDED_JOB` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_SUSPENDED_JOB` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_TASK`
--

DROP TABLE IF EXISTS `ACT_RU_TASK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_TASK` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DELEGATION_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `DUE_DATE_` datetime(3) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CLAIM_TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`),
  KEY `ACT_FK_TASK_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_TASK_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_TASK_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_TASK_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_TASK`
--

LOCK TABLES `ACT_RU_TASK` WRITE;
/*!40000 ALTER TABLE `ACT_RU_TASK` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_TASK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_TIMER_JOB`
--

DROP TABLE IF EXISTS `ACT_RU_TIMER_JOB`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_TIMER_JOB` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_TIMER_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_TIMER_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_TIMER_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TIMER_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_TIMER_JOB`
--

LOCK TABLES `ACT_RU_TIMER_JOB` WRITE;
/*!40000 ALTER TABLE `ACT_RU_TIMER_JOB` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_TIMER_JOB` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_VARIABLE`
--

DROP TABLE IF EXISTS `ACT_RU_VARIABLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_VARIABLE` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`),
  KEY `ACT_FK_VAR_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_VAR_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_VAR_BYTEARRAY` (`BYTEARRAY_ID_`),
  CONSTRAINT `ACT_FK_VAR_BYTEARRAY` FOREIGN KEY (`BYTEARRAY_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_VARIABLE`
--

LOCK TABLES `ACT_RU_VARIABLE` WRITE;
/*!40000 ALTER TABLE `ACT_RU_VARIABLE` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_VARIABLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CRA_PERSON`
--

DROP TABLE IF EXISTS `CRA_PERSON`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CRA_PERSON` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CRA_PERSON`
--

LOCK TABLES `CRA_PERSON` WRITE;
/*!40000 ALTER TABLE `CRA_PERSON` DISABLE KEYS */;
/*!40000 ALTER TABLE `CRA_PERSON` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OA_EXPENSE_ACCOUNT`
--

DROP TABLE IF EXISTS `OA_EXPENSE_ACCOUNT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OA_EXPENSE_ACCOUNT` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATE` datetime DEFAULT NULL,
  `MONEY` decimal(19,2) DEFAULT NULL,
  `PROC_INST_ID` varchar(255) DEFAULT NULL,
  `USER_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OA_EXPENSE_ACCOUNT`
--

LOCK TABLES `OA_EXPENSE_ACCOUNT` WRITE;
/*!40000 ALTER TABLE `OA_EXPENSE_ACCOUNT` DISABLE KEYS */;
/*!40000 ALTER TABLE `OA_EXPENSE_ACCOUNT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OA_SALARY`
--

DROP TABLE IF EXISTS `OA_SALARY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OA_SALARY` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BASE_MONEY` decimal(19,2) DEFAULT NULL,
  `USER_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OA_SALARY`
--

LOCK TABLES `OA_SALARY` WRITE;
/*!40000 ALTER TABLE `OA_SALARY` DISABLE KEYS */;
/*!40000 ALTER TABLE `OA_SALARY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OA_SALARY_ADJUST`
--

DROP TABLE IF EXISTS `OA_SALARY_ADJUST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OA_SALARY_ADJUST` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ADJUST_MONEY` decimal(19,2) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  `DSCP` varchar(255) DEFAULT NULL,
  `PROC_INST_ID` varchar(255) DEFAULT NULL,
  `USER_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OA_SALARY_ADJUST`
--

LOCK TABLES `OA_SALARY_ADJUST` WRITE;
/*!40000 ALTER TABLE `OA_SALARY_ADJUST` DISABLE KEYS */;
/*!40000 ALTER TABLE `OA_SALARY_ADJUST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OA_VACATION`
--

DROP TABLE IF EXISTS `OA_VACATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OA_VACATION` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BEGIN_DATE` datetime DEFAULT NULL,
  `WORK_DAYS` int(11) DEFAULT NULL,
  `END_DATE` datetime DEFAULT NULL,
  `PROC_INST_ID` varchar(255) DEFAULT NULL,
  `REASON` varchar(255) DEFAULT NULL,
  `USER_ID` varchar(255) DEFAULT NULL,
  `VAC_TYPE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OA_VACATION`
--

LOCK TABLES `OA_VACATION` WRITE;
/*!40000 ALTER TABLE `OA_VACATION` DISABLE KEYS */;
/*!40000 ALTER TABLE `OA_VACATION` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-28  9:43:59
