package src.Tests;

import org.junit.Assert;
import org.junit.Test;
import src.Core.OperationLabels;

public class OperationLabelsTests {

    @Test
    public void pareAllAvailableOperators()
    {
        String[] expectedParsableOperators = {"+", "-", "*", "/", "%"};

        for(String operator : expectedParsableOperators)
            Assert.assertTrue(OperationLabels.isOperator(operator));
    }

}
