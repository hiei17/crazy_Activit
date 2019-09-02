/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.crazyit.activiti;

import java.util.Map;

import org.activiti.dmn.api.RuleEngineExecutionResult;

public interface DmnRuleService {

	/**
	 * 根据决策表的key来执行
	 */
	RuleEngineExecutionResult executeDecisionByKey(String decisionKey,
			Map<String, Object> input);

	/**
	 * 根据租户id、decisionKey来执行
	 */
	RuleEngineExecutionResult executeDecisionByKeyAndTenantId(
			String decisionKey, Map<String, Object> input, String tenantId);

	/**
	 * 根据父部署的id和decisionKey来执行
	 */
	RuleEngineExecutionResult executeDecisionByKeyAndParentDeploymentId(
			String decisionKey, String parentDeploymentId,
			Map<String, Object> input);

	/**
	 * 根据父部署的id、decisionKey和租户id来执行
	 */
	RuleEngineExecutionResult executeDecisionByKeyParentDeploymentIdAndTenantId(
			String decisionKey, String parentDeploymentId,
			Map<String, Object> input, String tenantId);
}
