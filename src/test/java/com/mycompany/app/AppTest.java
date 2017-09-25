package com.mycompany.app;

import java.util.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
   public void testFound() {
ArrayList<String> array = new ArrayList<>(Arrays.asList("ali","batu","servet","muro"));
ArrayList<String> array1 = new ArrayList<>(Arrays.asList("ali","miki","servet","muro"));
ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1,3,4));

      assertTrue(new App().search(array,array1,array2));
    }

    public void testNotFound() {
      ArrayList<String> array = new ArrayList<>(Arrays.asList("ali","batu","servet","muro"));
      ArrayList<String> array1 = new ArrayList<>(Arrays.asList("ali","miki","servet","muro"));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1,2,4));

      assertFalse(new App().search(array,array1,array2));
    }

    public void testEmptyArray() {
      ArrayList<String> array = new ArrayList<>(Arrays.asList());
      ArrayList<String> array1 = new ArrayList<>(Arrays.asList("ali","miki","servet","muro"));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1,3,4));

      assertFalse(new App().search(array,array1,array2));
    }


 
}
