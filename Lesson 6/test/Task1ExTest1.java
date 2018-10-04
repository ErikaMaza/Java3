package test;

import org.junit.Test;
import task.Task1;

class Task1ExTest {
    private Task1 task1;

    public void startTest() {
        task1 = new Task1();
    }

    @Test(expected = RuntimeException.class)
    public void testAfterLast4Ex() {
        Task1.AfterLast4(new int[]{0, 3, 7, 5, 0, 0, 3, 2});
    }
}

