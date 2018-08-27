package com.vincent.design.structural_pattern.facade_pattern;


public class Computer {

	private CPU cpu;
	private Disk disk;
	private Memory memory;

	public Computer() {
		super();
		cpu = new CPU();
		disk = new Disk();
		memory = new Memory();
	}

	public void start() {
		cpu.start();
		disk.start();
		memory.start();
	}

	public void shutDown() {
		cpu.shutDown();
		disk.shutDown();
		memory.shutDown();
	}

	

}
