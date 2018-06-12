
package finalprojectB;

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
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	 /*  
	   assertTrue(urlVal.isValid("http://www.google.com"));
	   assertTrue(urlVal.isValid("http://www.google.com/"));
	   assertTrue(urlVal.isValid("http://youtu.be/dQw4w9WgXcQ?t=1s"));
	   assertTrue(urlVal.isValid("reddit.com/r/pcmassterrace"));
	   assertTrue(urlVal.isValid("https://youtu.be/dQw4w9WgXcQ?t=1s"));
	   assertTrue(urlVal.isValid("216.58.216.42"));
	   
	   assertFalse(urlVal.isValid(null));
	   assertFalse(urlVal.isValid("http://kfj9sdjf98.jjJjj/"));
   */
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   
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
			   System.out.println(result);			  
			   System.out.print(" is wrong:");
			   System.out.print(message.toString());
			   System.out.printf("%n");
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
			   
	   
	   
   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
