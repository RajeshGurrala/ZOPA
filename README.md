# ZOPA
GetQuote

This framework has been created with selenium/Junit and Maven around a single BDD scenario that tests screen till 'calculate my rates' button. 
frame work is fully functional and has-
1) A screen shot method that captures an image of the UI when ever there is a test failure. 
screen shots are generated and stored in a folder called 'screen shots' with in the framework.
a demo screen shot is already placed in the folder. 

2) An integrated 3rd party reporting tool that captures results as a html file . 
this file is automatically refreshed after each test execution and provides results of that particular run in the form of pie charts. 
this file is called reports.html and is accessible form the folder named 'output' in the frame work

3) Cross browser testing functionality is achieved with the browser method, which provides browser parameter from a config.properties file. currently the scenario is tested on chrome but with little modifications this could be run on IE and firefox as well.  
