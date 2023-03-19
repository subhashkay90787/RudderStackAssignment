#Assignments for Rudder Stack

##Adding a tracking plan to the database
The project contains two modules.
* api
* ui

UI Module is added as a dependency to the api module and it wraps the ui and adds it to 
the static path of the jar.



###API Module

The api module hosts apis to add tracking plan update tracking plan and add events.
This also hosts fetch events and fetch tracking plans apis.

###UI Module
UI module is made on react and is wrapped around my maven. The UI build uses plugins to add the build react files to the static path
and then builds a jar over it which is imported by api.


####Steps to run the code
Make sure maven and java is installed. Any version greater than java 8 should work.
Go to the root folder (assignment parent) and do a clean install.
This shall push the ui dependency to the local maven repo and then it can be imported by the api module
Once the api module can access the ui dependency one can run the code in an IDE or run them as
a jar application.

Test coverage for the apis are implemented (around 90% of the code has a test coverage, although this was not developed on TDD pattern).
React test coverage has not yet been implemented
A docker file has been made in case one wants to host it on Docker(Registry image has not been tested)

