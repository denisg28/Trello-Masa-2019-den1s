package com.telran.tests;


import org.testng.annotations.BeforeClass;


import static org.testng.Assert.fail;

public abstract class TestBase
{

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() throws InterruptedException
    {
        app.init();


    }

    ////////////

    ////////////

    ////////////

    ////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////////


    public void tearDown() throws Exception {
        app.stop();
        String verificationErrorString = app.verificationErrors.toString();
      if (!"".equals(verificationErrorString)) {
        fail(verificationErrorString);
      }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
}
