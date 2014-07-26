Generate HTML Page(Lonely Planet)
==============

Introduction
-----------

* Two.xml files  
	- taxonomy.xml holds the information about how destinations are related to each other 
	- destinations.xml holds the actual text content for each destination.

* Build a batch processor that takes these input files and produces an .html file (based on the output template given with this test) for each destination. Each generated web page must have:
	1. Some destination text content. Use your own discretion to decide how much information to display on the destination page.
	2. Navigation that allows the user to browse to destinations that are higher in the taxonomy. For example, Beijing should have a link to China.
	3. Navigation that allows the user to browse to destinations that are lower in the taxonomy. For example, China should have a link to Beijing.


How to build
-----------

```
  $ .gradlew jar
```

How to run test
-----------

```
  $ gradle test 
```

How to run the application
-----------

```
  $ cd release
  $ ./pageGenerator -t <Taxonomy_file> -d <Destination_file> -o <Output directory>
  For example:
    ./pageGenerator -t sample/taxonomy.xml -d samle/destination.xml-o /tmp   
```
