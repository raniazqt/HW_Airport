package com.hw.airport.util;

import java.util.concurrent.atomic.AtomicInteger;

public final class IDGenerator {

	    private static final AtomicInteger sequence = new AtomicInteger(1);

	    private IDGenerator() {}

	    public static int generate(){
	        return sequence.getAndIncrement();
	    }
	}

