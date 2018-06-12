
package finalprojectB;

import finalprojectA.ResultPair;
import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing
	   UrlValidator val = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES + UrlValidator.NO_FRAGMENTS);
	   assertTrue(val.isValid("http://www.reddit.com"));
	   assertTrue(val.isValid("http://216.58.216.42"));
	   assertTrue(val.isValid("http://www.23984j32498j234.agdfa/"));
	   assertFalse(val.isValid("http://216.asd32983y982y98327//"));
	   assertFalse(val.isValid("http://reddit.com:r:pcmasterrace"));
	   assertFalse(val.isValid("http://reddit.com:-550"));
	   assertFalse(val.isValid("http://google.com/??&&??&&??& &??")); //test query
	   assertFalse(val.isValid("http://google.com/#")); //test fragment
	   
	   //tests after here fail
	   
	   assertTrue(val.isValid("https://youtu.be/dQw4w9WgXcQ?t=1s"));
	   assertTrue(val.isValid("https://youtube.com/watch?v=dQw4w9WgXcQ?t=1s"));
	   assertFalse(val.isValid("555.12.0.15"));
	   assertTrue(val.isValid("http://kfj9sdjf98.jjJjj/"));
	   assertTrue(val.isValid("https://google.com/"));
	   assertTrue(val.isValid("reddit.com/r/pcmasterrace"));
	   assertTrue(val.isValid("216.58.216.42"));
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	  
	   System.out.println("\n\nFIRST PARTITION\n\n");
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);	   
	   ResultPair[] testUrlPort = {
			   new ResultPair(":80", true),
			   new ResultPair(":65525", true),
			   new ResultPair(":0", true),
			   new ResultPair("", true),
			   
			   new ResultPair(":-1", false),
			   new ResultPair(":65636", false),
			   new ResultPair(":65a", false)
	   };
	   
	   String base = "http://www.google.com";
	   String tail = "/test";
	   
	   for(int i = 0; i < testUrlPort.length; i++) {
		   StringBuilder message = new StringBuilder("");	
		   message.append(base);
		   message.append(testUrlPort[i].item);
		   message.append(tail);
		   
		   //Test isValid();
		   boolean validity, result;
		   validity = testUrlPort[i].valid;
		   result = urlVal.isValid(message.toString());
		   
		   if(validity != result) {
			   System.out.print(validity);			  
			   System.out.print(" is wrong:  ");
			   System.out.print(message.toString());
			   System.out.printf("\n");
		   }
	   }
	   
	   
	   System.out.println("\n\nEND OF FIRST PARTITION\n\n");
   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	     
	   System.out.println("\n\nSECOND PARTITION\n\n");
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);	   
	   ResultPair[] testUrlScheme = {
			   new ResultPair("http://", true),
               new ResultPair("ftp://", true),
               new ResultPair("h3t://", true),
               new ResultPair("", true),
               
               new ResultPair("3ht://", false),
               new ResultPair("http:/", false),
               new ResultPair("http:", false),
               new ResultPair("http/", false),
               new ResultPair("://", false)
       };
	   
	   String tail = "www.google.com:80/test1";
	   
	   for(int i = 0; i < testUrlScheme.length; i++) {
		   StringBuilder message = new StringBuilder("");	
		   message.append(testUrlScheme[i].item);
		   message.append(tail);
		   
		   //Test isValid();
		   boolean validity, result;
		   validity = testUrlScheme[i].valid;
		   result = urlVal.isValid(message.toString());
		   
		   System.out.println("hello");
		   if(validity != result) {
			   System.out.print(validity);			  
			   System.out.print(" is wrong:  ");
			   System.out.print(message.toString());
			   System.out.printf("\n");
		   }
	   }
	   
	   
	   System.out.println("\n\nEND OF SECOND PARTITION\n\n");
   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing
	   System.out.println("\n\ntestIsValid()\n\n");	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   ResultPair[] testUrlScheme = {
			   new ResultPair("http://", true),
			   new ResultPair("ftp://", true),
			   new ResultPair("h3t://", true),
			   new ResultPair("", true),		   
			   new ResultPair("http:/", false),
			   new ResultPair("3ht://", false)
	   };
	   ResultPair[] testUrlAuthority = {
			   new ResultPair("www.google.com", true),
			   new ResultPair("go.com", true),
			   new ResultPair("go.au", true),
			   new ResultPair("255.255.255.255", true),
			   
			   new ResultPair("256.256.256.256", false),
			   new ResultPair("go.a", false),
			   new ResultPair("aaa.", false),
			   new ResultPair("", false)
	   };
	   ResultPair[] testUrlPort = {
			   new ResultPair(":80", true),
			   new ResultPair(":65525", true),
			   new ResultPair(":0", true),
			   new ResultPair("", true),
			   
			   new ResultPair(":-1", false),
			   new ResultPair(":65636", false),
			   new ResultPair(":65a", false)
	   };
	   ResultPair[] testPath = {
			   new ResultPair("/test1", true),
			   new ResultPair("/t123", true),
			   new ResultPair("", true),
			   
			   new ResultPair("/..", false),
			   new ResultPair("/../", false),
			   new ResultPair("/..//file", false)
	   };
	   
	   int[] testIndex = {0, 0, 0, 0};
	   int numTests = (testUrlScheme.length * testUrlAuthority.length * testUrlPort.length * testPath.length);
	   for(int i = 0; i < numTests; i++) {
		   StringBuilder message = new StringBuilder("");
		   
		   //get message
		   message.append(testUrlScheme[testIndex[0]].item);
		   message.append(testUrlAuthority[testIndex[1]].item);
		   message.append(testUrlPort[testIndex[2]].item);
		   message.append(testPath[testIndex[3]].item);
		   
		   //get correct or not
		   boolean validity = true;
		   if(testUrlScheme[testIndex[0]].valid) { validity = false;}
		   if(testUrlAuthority[testIndex[1]].valid) { validity = false;}		   
		   if(testUrlPort[testIndex[2]].valid) { validity = false;}
		   if(testPath[testIndex[3]].valid) { validity = false;}		   
		   
		   //Test isValid();
		   boolean result;
		   result = urlVal.isValid(message.toString());
		   if(result != validity) {
			   System.out.print(result);			  
			   System.out.print(" is wrong:  ");
			   System.out.print(message.toString());
			   System.out.printf("\n");
		   }
		   
		   //increment
		   testIndex[3]++;
		   if(testIndex[3] == testPath.length) {
			   testIndex[3] = 0; 
			   testIndex[2]++;
			   if(testIndex[2] == testUrlPort.length) {
				   testIndex[2] = 0;
				   testIndex[1]++;
				   if(testIndex[1] == testUrlAuthority.length) {
					   testIndex[1] = 0;
					   testIndex[0]++;
				   }
			   }
		   }
	   }
	   System.out.println("\n\nend of testIsValid\n\n");   
   }
   


}
