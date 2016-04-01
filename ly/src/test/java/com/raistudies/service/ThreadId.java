package com.raistudies.service;

import java.util.concurrent.atomic.AtomicInteger;

 public class ThreadId {
     // Atomic integer containing the next thread ID to be assigned
     private static final AtomicInteger nextId = new AtomicInteger(0);
     private static int result = 0;
     // Thread local variable containing each thread's ID
     private static final ThreadLocal<Integer> threadId =
         new ThreadLocal<Integer>() {
             @Override protected Integer initialValue() {
                 return nextId.getAndIncrement();
         }
     };

     // Returns the current thread's unique ID, assigning it if necessary
     public static int get() {
         return threadId.get();
     }
     
     private static class TestClient extends Thread {  
         private ThreadId sn;  
   
         public TestClient(ThreadId sn) {  
             this.sn = sn;  
         }  
   
         public void run() {  
             for (;;) {  
            	 
            	 while(result >= 30)
            	 return;
            	 
            	 Math.random();
            	 result++;
            	 
            	 
                 // ④每个线程打出3个序列值  
                 System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["  
                          + sn.get() + "]" + result);  
             }  
         }  
     }  
     
     
     static String version1 = "0.1.3";
     static String version2 = "1.2";
     static String[] verArr1 = version1.split(".");
     static String[] verArr2 = version2.split(".");
	 
	 static int len = Math.min(verArr1.length, verArr2.length);
     public int compareVersion() {
    	
    	
    	
    	 
    	 
    	 
         double v1 = Double.parseDouble(version1);
         double v2 = Double.parseDouble(version2);
         return v1==v2?0:v1>v2?1:-1;
         
     }
     public static int compareVersion(String version1, String version2) {
    	    String[] levels1 = version1.split("\\.");
    	    String[] levels2 = version2.split("\\.");

    	    int length = Math.max(levels1.length, levels2.length);
    	    for (int i=0; i<length; i++) {
    	        Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
    	        Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
    	        int compare = v1.compareTo(v2);
    	        if (compare != 0) {
    	            return compare;
    	        }
    	    }

    	    return 0;
    	}
     
     
     
     public static void main(String[] args){
    	 
     }
     
     
     
     
     
     
     
      class ListNode {
    	     int val;
    	     ListNode next;
    	     ListNode(int x) { val = x; }
    	 }
     class Solution {
    	    public ListNode oddEvenList(ListNode head) {
    	    	ListNode list1 = null;
    	    	ListNode list2 = null;
    	    	for(;;){
		    		int next = head.val;
	    	    	while(head.next == null)break;
	    	    	if(next%2==0) 
	    	    		list2.next=head;
	    	    	list1.next=head;
    	    	
    	    	}
//    	    	list1.next=list2;
//    	        return list1;
    	    }
    	}
     
 }
