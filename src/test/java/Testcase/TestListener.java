package Testcase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("===== Test Suite Started: " + context.getName() + " ====="); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("===== Test Suite Finished: " + context.getName() + " ====="); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("🟡 Test Started: " + result.getMethod().getMethodName()); //$NON-NLS-1$
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("🟢 Test Passed: " + result.getMethod().getMethodName()); //$NON-NLS-1$
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("🔴 Test Failed: " + result.getMethod().getMethodName()); //$NON-NLS-1$
        System.out.println("❌ Reason: " + result.getThrowable()); //$NON-NLS-1$
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("🟠 Test Skipped: " + result.getMethod().getMethodName()); //$NON-NLS-1$
    }
}
