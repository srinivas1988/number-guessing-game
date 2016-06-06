package com.demo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * Created by spyarasani on 6/6/16.
 */
public class HighLowLogicTest {

    private static final int RANGE = 100;

    private static final String HIGHER = "higher";

    private static final String LOWER = "lower";

    private static final String YES = "yes";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private HighLowLogic highLowLogic;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.out.println(RANGE);
        highLowLogic = new HighLowLogic(RANGE);
    }

    @Test
    public void testHigher() throws Exception {
        final PrintStream consoleOutput = System.out;
        final PipedOutputStream testInput = new PipedOutputStream();
        final PipedOutputStream out = new PipedOutputStream();
        final PipedInputStream testOutput = new PipedInputStream(out);
        System.setIn(new PipedInputStream(testInput));
        System.setOut(new PrintStream(out));
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    PrintStream testPrint = new PrintStream(testInput);
                    BufferedReader testReader = new BufferedReader(
                            new InputStreamReader(testOutput));
                    while (true) {
                        testPrint.println((int) (Math.random() * 100));
                        consoleOutput.println(testReader.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace(consoleOutput);
                }
            }
        }).start();
        highLowLogic.guess(HIGHER);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
        highLowLogic = null;
    }
}
