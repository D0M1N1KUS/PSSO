package src.Core;

import src.Core.OperationLabels;

public interface IOperationNode {
    int compute(int a, int b);

    default String getLabel() throws Exception {
        return OperationLabels.getLabelForNode(this);
    }
}
