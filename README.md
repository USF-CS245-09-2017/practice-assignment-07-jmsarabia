# PracticeAssignment07

The test file will fail the passed timing test because the path given in the test code 
will give an exception for finding web2.
I included a line to simplify/find the path to the web2 file and it passes the timing 
test (avg. 93 ms).
The test and the prompt seem to not really care about load factor, so I did not include
it in my submission. 

The put function had a vague explanation for dealing with duplicate keys, so I left one
way to deal with it commented in, while I implemented the version where we keep the 
position of the key in the bucket and change the existing value.

The hashCode function: I left commented in my version of a hash function, but used
the built in hashCode() for Strings.