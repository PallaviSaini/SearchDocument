# SearchDocument

1.This project searches the user input word in the set of files(having data 35 Lac)
2.The choice is provided to the user to do the searching on below criteria
  a. Simple string matching 
  b. Text search using regular expressions
  c. Preprocess the content and then search the index
3. Gives the output to the user in the terms of relevancy
   Eg :- Search results: File2.txt – X matches File1.txt - X matches File3.txt – X matches Elapsed time: 40 ms
   
   1. Technology used is ELK stash for indexing documents
   2. Need to push data into elastic server through logstash before using the indexed document choice.
   3. Specify the index name as per the file name to be pushed in the elastic search server
   4. The search is done in the basis of these indexes created.
   5. We can scale this application by using multiple Elastic Search instances, to speed up the process of search in an indexed document.

