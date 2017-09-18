package com.countdownlatch;

import java.util.LinkedList;
import java.util.List;

public class Test {

	@org.junit.Test
	public void testBatch() {
		BatchExecutor batchExecutor = new BatchExecutor();
		
		List<Task> addTaskBatch = new LinkedList<>();
		addTaskBatch.add(new AddTask(11, 66));
		addTaskBatch.add(new AddTask(33, 33));
		addTaskBatch.add(new AddTask(44, 55));
		
		batchExecutor.process(addTaskBatch);
		System.out.println("Add batch output:" + addTaskBatch);

		
		List<Task> subtractTaskBatch = new LinkedList<>();
		subtractTaskBatch.add(new SubtractTask(11, 66));
		subtractTaskBatch.add(new SubtractTask(33, 33));
		subtractTaskBatch.add(new SubtractTask(44, 55));
		
		batchExecutor.process(subtractTaskBatch);
		System.out.println("Subtract batch output:" + subtractTaskBatch);
	}

}
