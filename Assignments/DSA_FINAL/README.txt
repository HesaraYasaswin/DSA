-----------
README file  Hesara Yasaswin Pathirana
-----------

-------------------------------------------------------------------------------

How To Run

UnitTest<class>

Run as normal java programs for the unit tests.

if checking individual tasks from 1 to 6,

run UnitTestGraph for task 1
run UnitTestGraphTransversal for task 2 and 3
run UnitTestHashTable for task 4
run UnitTestHeap for task 5
run UnitTestItineraryPlanner for task 6
run main to run all of them

-------------------------------------------------------------------------------

DSAQueue.java - this code is a queue data structure that uses the linked list implementation.

IMPLEMENTATION OF A FILO QUEUE

UnitTestDSAQueue - test harness for DSAQueue

DSALinkedList.java - this code implements a doubly linked list data structure.
(it has a reference to both the previous and next element in the list.)

IMPLEMENTATION OF LINKED LIST


UnitTestDSALinkedList - test harness for DSALinkedList



------
TASK 1
------
Graph.java - this is the implementation for task 1, 
the code represents the graph structure
the "printAdjacencyList" method prints the adjacencey list for the graph details on the "location.txt"
the Edge class is the private inner class of the graph class.

IMPLEMENTATION OF DIRECTED GRAPH.

UnitTestGraph - test harness for task 1.

------------
TASK 2 AND 3
------------
GraphTraversal.java - this is the implementation for task 2 and 3, 
The constructor GraphTraversal(String locationFile, String uavDataFile) takes two file names as input and 
loads the location data and UAV data from those files by calling the loadLocationData() and loadUAVData() methods.
the insert,delete and search location are implemented here.
the main method is is done at last where it calles the location file and UAV data file to intialize the graph.


IMPLEMENTATION OF BFS,DFS AND THE INSERT,DELETE AND SEARCH METHODS.

UnitTestGraphTraversal.java - 
this is the test harness for the grpah traversal, the user can choose to find the shorted path, perform a dfs traversal and pront the uav data for the specific location asked by the user.



------
TASK 4
------
HashTable.java - this is the implementation for task 4,
it implements the hash table to store and retrieve UAV data.
"TABLE_SIZE" determines the size of the hash table.
usung the hash funxction it stores and retrieves the data appropriately.


IMPLEMENTATION OF HASH TABLE

UnitTestHashTable.java - 
this is the test harness for the hash table .the user can enter the any location to access the UAV data.


------
TASK 5
------
Heap.java - this is the implementation for task 5,
it implements a binary max heap data structure.

IMPLEMENTATION OF PRIORITY MAX HEAP


UnitTestHeap.java - 
this is the test harness for the heap
enter the number of enteries eg : 2
with random uav data and the risk levels will be calculated and displayed.


------
TASK 6
------
ItineraryPlanner.java - this is the implementation for task 6,
this code uses the Dijkstra's algortihm to plan itineraries between different locations.
"INFINITY" is defines to represent an infinite distance



IMPLEMENTATION OF ITINERARY PLANNER

UnitTestItinerary.java -
this is the test harness for the Itinerary task 6,


--------
--------
Main.java
--------

this contains the menu system from task 1 to 6.














