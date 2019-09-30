package org.crazyit.activiti;

import org.activiti.bpmn.model.FlowElement;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityImpl;

/**
 * @Author: panda
 * @Date: 2019/9/20 0020 22:15
 */
public class SequenceflowListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution delegateExecution) {
        FlowElement flowElement = delegateExecution.getCurrentFlowElement();
        String id = flowElement.getId();
        ExecutionEntityImpl parent = (ExecutionEntityImpl) (delegateExecution.getParent());
        String processDefinitionKey = parent.getProcessDefinitionKey();
        String businessKey = delegateExecution.getProcessInstanceBusinessKey();
        System.out.println("flow id:"+id);
        System.out.println("businessKey:"+businessKey);

        //就是	<process id="panda" name="pandaName" isExecutable="true">
        System.out.println("process definition key:"+processDefinitionKey);
    }
}