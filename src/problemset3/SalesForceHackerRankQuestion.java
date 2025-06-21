package problemset3;

/*
Problem statement:
Find faulty servers. In logs, we can identify which server has failure. The log message will be provided
in terms of collection List. The format will be serverID with status. The status can be success or error. Below is the sample log message:
[server1 error, server2 error, server1 error, server2 success, server3 error]

Your function should accept two inputs:
1. number of servers (in integer)
2.log messages  (in List)

Constraint:
A server can be treated as faulty, only if it reports consecutively 3 times error status in log message

output: Print faulty servers

Note: You can free to assume any missing information and you should state it
Sample examples:
Input 1: 3, logMessageInList[server1 error, server1 error, server2 error,server1 error,server2 error,server2 error,server2 error,server3 error]
        Here 3 is number of total servers.
        logMessageInList given in List.
        List contains data [server1 error, server1 error, server2 error,server1 error,server2 error,server2 error,server2 error,server3 error]

output: server2
output Explanation: Here server2 is reported 3 times consecutively error. Hence, it's faulty server.

Input 2: 2, logMessagesInList
        Here 2 is number of total servers.
        logMessageInList is given in List.
        List contains data [server1 error, server2 success,server1 error,server2 error,server2 error,server2 error]
output: server2, logMessagesInList
output Explanation: Here server2 is reported 3 times consecutively error. Hence, it's faulty server.

Questions to be clarified from the problem statement:
1. If server status is error for 3 times consecutively and in the 4th time if it's reports as success. Should we still need to treat it as faulty server?
   Ex: [server1 error,server1 error,server1 error,server1 success]
2.Once the server status is initially reported as success, will there be any possibility that it can report as failure later in the logs
  Ex: [server1 success,server2 error,server1 error,server1 error]


 Psueudo Steps:
 - Take log message one by one
 - check whether it has error message
     - if so, store it in map with count
         -check if count ==3
         -if so, increment count of faultyservercount
         -reset count to 0
 -check whether it has success message
 - if so, take serverid from message
         -Iterate map and check whether this serverid is stored
         -if found, reset count=0 as we have not faced consecutive errors


  Approach 2:
 //---------------------------------------------------------------

 Begin Function:
   1.Read log message from list one by one using loop
   - Store first log message in some variable as previous before starting the loop
   - Start loop index from second log message. As we want to compare first log message(previous) with current log message(second log message)
   Begin Loop:
    1.1 Read log message and store it in currentLog message
    1.2 check whether currentLog message has error string in it
        1.2.1 if so, compare previous and currentLog messages are same
                  - if so, maintain a serverErrorCount variable and increment it
                  - Check serverErrorCount is equal to 3
                          - if so, it's  faulty server. Add in some separate list to store faulty servers
        1.2.2 else
              -assign to previousLogMessage=currentLogMessage
              -Reset  serverWithErrorCount=1
    END Loop
  END Function


   in loop from i =1 to n-2
   -store in currentLogMessage
   -check if it has error
     -check   previousLogMessage is equal to currentLogMessage
        -incremnt serverWithErrorCount
        -if serverWithErrorCount==3
            -add in uniqueFaultyServers
            -Reset serverWithErrorCount=1
      else
        -assign in previousLogMessage=currentLogMessage
        -Reset incremnt serverWithErrorCount=1

TCs:
//Same server with 3 times error status
 [server1 error,server1 error,server1 error]

//No faulty servers in logs
[server1 error,server2 error,server3 error]

//Same server error status is 3 times in logs but it's not repeated consecutively
[server1 error,server2 error,server1 error,server3 error,server1 error]

//Same server error status is 2 times consecutively in logs but in 3rd time reports as success status
[server1 error,server1 error,server1 success]

//Same server more than 3 times error consecutively (but not in multiples of 3, ex: error repeated for 4,5,7,10,35,100 times etc..This is basically to check once we already know faulty server but the same server is being reported as faulty multiple times)
[server1 error,server1 error,server1 error,server1 error]


// A server which goes intermittently up and down
[server1 success,server2 error,server1 error,server3 error,server1 success, server4 success,server1 error,server1 error,server1 error]

// Same server multiple of 3 times error  consecutively(repeated 6,9,12 times etc.. As per requirement 3 times server error is faulty, this validation is to check program capability when it encounters multiples of 3 of the same server error status consecutively)
[server1 error,server1 error,server1 error,server1 error,server1 error,server1 error]

//log message size is less than 3. This lies under no faulty servers because requirement states minimum 3 errors are required to consider as a faulty server
[server1 error,server1 error]

//server with success status followed by the same server  with faulty server
[server1 error,server2 error, server1 success, server1 error,server1 error,server1 error]

//Multiple servers with 3 times consecutively success status
[server1 success,server1 success,server1 success,server2 success,server2 success,server2 success]

//Multiple servers with 3 times error status
[server1 error,server1 error,server1 error,server2 error,server2 error,server2 error,server3 error,server3 error,server3 error]

//Multiple servers with error status is less than 3 times
[server1 error,server1 error,server1 success,server2 error,server2 error,server4 error,server3 error,server5 error,server3 error]

//Multiple servers with error status is less than 3 times but one of the server found as faulty server at the end of the log
[server1 error,server2 error,server3 error,server1 error,server1 error,server1 error]

//Multiple servers with error status is less than 3 times but one of the same server found as faulty server in beginning,mid and end of the log(Repeated 3 times at each position)
[server1 error,server1 error,server1 error,server4 error,server2 error,server1 error,server1 error,server1 error,server3 error,server5 error,server1 error,server1 error,server1 error]

//unique servers error followed by faulty server
[server1 error,server2 error,server3 error,server10 error,server10 error,server10 error]


//log message is empty or null

Extended approach:
1. If there is less number of server count and log message is size too big. In this case, need not to check all the log messages.
   Ex: Let's say there is only one server i.e.,  server1 and log message size is 1000.
      In this case, there might be possibility that all the logs might be reported as error status for server1
      or with the combination of errors and success.
      Let's say first 3 log messages reported as error consecutively for sever1, need not to check further log messages. As we already know server1 is faulty.
      So that we can skip checking remaining 997 log messages.
      This approach we can make it generic by checking number of faultyServersCount equal to totalNuberOfGivenServers from input, then we can skip checking remaining
      log messages. This statement we can place in the beginning of the loop and if condition is true, break the loop.
2. We can reduce number of iterations to half of the logMessageList size. If we start checking in 2 directions for each iteration beginning point and ending point for consecutive occurrences
   errors.
   Ex: Let's say there is 100 servers and logMessageList size is 1000. We need not to iterate and check 1000 log messages. We can reduce it 500.
       This we can achieve by checking server error from starting position with the help of certain additional variables.

 */


import java.util.*;

public class SalesForceHackerRankQuestion {

    ArrayList<String> faultyServersWithStatusList = new ArrayList<>();

    public static int faultyServerCount(int numberOfServers, List<String> logs) {

        String logMessage = "";
        HashMap<String, Integer> serverWithErrStatusInMap = new HashMap<>();
        ArrayList<String> faultyServerList = new ArrayList<>();
        int occuranceValue = 1;
        int countOfFaultyServers = 0;
        String serverId = "";
        for (int i = 0; i < logs.size(); i++) {
            logMessage = logs.get(i);
            if (logMessage.contains("error")) {

                if (!serverWithErrStatusInMap.isEmpty()) {
                    if (serverWithErrStatusInMap.containsKey(logMessage)) {

                        occuranceValue = serverWithErrStatusInMap.get(logMessage);
                        serverWithErrStatusInMap.put(logMessage, ++occuranceValue);

                        if (occuranceValue == 3) {
                            faultyServerList.add(logMessage.split(" ")[0]);
                           /* countOfFaultyServers++;
                            occuranceValue = 0;
                            //reset count
                            serverWithErrStatusInMap.put(logMessage, occuranceValue);

                            */
                        }

                    } else {
                        serverWithErrStatusInMap.put(logMessage, 1);
                    }
                } else {
                    //first element
                    serverWithErrStatusInMap.put(logMessage, 1);
                }
            } else if (logMessage.contains("success")) {

                serverId = logMessage.replace("success", "").trim();
                for (Map.Entry<String, Integer> mapData : serverWithErrStatusInMap.entrySet()) {
                    //reset count to 0
                    if (mapData.getKey().contains(serverId)) {
                        serverWithErrStatusInMap.put(mapData.getKey(), 0);
                        break;
                    }
                }

            }
        }

        return countOfFaultyServers;
    }

    public static void main(String[] args) {
        // List<String> logs=new ArrayList<>();


        List<String> logs = Arrays.asList("server1 error", "server1 success", "server1 error", "server2 error", "server2 error", "server2 error", "server1 error");
        /*logs.add("server1 error");
        logs.add("server1 error");
        logs.add("server1 error");*/



       /* log.add("server2 error");
        log.add("server1 error");
        log.add("server2 error");

        log.add("server1 error");
        log.add("server3 error");
        log.add("server2 error");
        log.add("server1 error");
        log.add("server3 error");


        log.add("server2 error");
        log.add("server1 error");
        log.add("server3 error");
        log.add("server2 error");
        log.add("server1 error");
        log.add("server3 error");
        log.add("server3 error");
        log.add("server1 error");
        log.add("server2 error");

*/
        SalesForceHackerRankQuestion prblm = new SalesForceHackerRankQuestion();

        //   findFaultyServers
        prblm.findFaultyServers(3, logs);

        // prblm.improvedSolution(3,logs);
        //System.out.println("Faulty servers :"+prblm.findFaultyServers(3,logs));


    }

    public void findFaultyServers(int numberOfServers, List<String> logs) {
        String previousLogMessage = "", currentLogMessage = "";
        int serverErrCount = 1;
        ArrayList<String> faultyServersWithStatusList = new ArrayList<>();
        if (logs.isEmpty()) {
            System.out.println("Empty log");
            return;
        } else if (logs.size() < 3) {
            System.out.println("No faulty servers");
            return;
        }
        //Store first log message from list
        previousLogMessage = logs.getFirst();
        //start log message index from second as we have compare it with first log message
        int logIndex = 1;
        while (logIndex < logs.size() - 1) {
            //store next log message in currentLogMessage
            currentLogMessage = logs.get(logIndex);
            //Check only servers which contains error status
            if (currentLogMessage.contains("error")) {

                //Check previous and current servers are same
                if (previousLogMessage.equals(currentLogMessage)) {

                    //If the server is already in the faulty server list or recognized as faulty server previously and if we encounter again the same server, need not check its log further
                    //Check only the server errors which are not recognized as faulty servers
                    if (!faultyServersWithStatusList.contains(currentLogMessage)) {
                        serverErrCount++;
                        //If the error count is consecutively 3, add it in faulty server List
                        if (serverErrCount == 3) {
                            faultyServersWithStatusList.add(currentLogMessage);
                            //Reset count to 1 to assess next server error count
                            serverErrCount = 1;
                        }
                    }

                } else {
                    //As previous and current servers are not matching, make current log as previous
                    previousLogMessage = currentLogMessage;
                    //Reset count to 1 to assess next server error count
                    serverErrCount = 1;
                }
            }
            //increment log index to check next log message
            logIndex++;
        }//end of while loop

        if (faultyServersWithStatusList.isEmpty()) {
            System.out.println("No faulty servers found");
        }
        //Print only faulty servers by excluding status from faultyServersWithStatusList
        faultyServersWithStatusList.forEach(element -> System.out.println(element.split(" ")[0]));

    }

    public int addInFaultyServerList(String currentLogMessage, String previousLogMessage, int serverErrCount) {


        if (currentLogMessage.contains("error")) {

            if (previousLogMessage.equals(currentLogMessage)) {

                if (!faultyServersWithStatusList.contains(currentLogMessage)) {
                    serverErrCount++;
                    if (serverErrCount == 3) {
                        faultyServersWithStatusList.add(currentLogMessage);
                        serverErrCount = 1;
                    }
                }

            } else {
                previousLogMessage = currentLogMessage;
                serverErrCount = 1;
            }
        }

        return serverErrCount;
    }

    public void improvedSolution(int numberOfServers, List<String> logs) {
        String previousLogFrmStartingIndx = "", previousLogFrmBottomIndx = "", currentLogFrmStartingIndx = "", currentLogFrmBottomIndx = "";
        int serverErrCountFromTop = 1;
        int serverErrCountFromBottom = 1;
        //   ArrayList<String> faultyServersWithStatusList=new ArrayList<>();
        if (logs.isEmpty()) {
            System.out.println("Empty log");
            return;
        } else if (logs.size() < 3) {
            System.out.println("No faulty servers");
            return;
        }

        //Store first log message from list
        previousLogFrmStartingIndx = logs.getFirst();
        previousLogFrmBottomIndx = logs.getLast();
        //start list index from second
        int logIndex = 1, nmuOfIteration;
        int logIndexFromBottom = logs.size() - 2;
        int halfLogSize = logs.size() / 2;
        if (halfLogSize < 3) {
            nmuOfIteration = logs.size();
        } else {
            nmuOfIteration = halfLogSize;
        }

        while (logIndex <= nmuOfIteration) {

            if (faultyServersWithStatusList.size() == numberOfServers) {
                break;
            }
            currentLogFrmStartingIndx = logs.get(logIndex);
            currentLogFrmBottomIndx = logs.get(logIndexFromBottom);

            serverErrCountFromTop = addInFaultyServerList(currentLogFrmStartingIndx, previousLogFrmStartingIndx, serverErrCountFromTop);
            if (logs.size() >= 6) {
                serverErrCountFromBottom = addInFaultyServerList(currentLogFrmBottomIndx, previousLogFrmBottomIndx, serverErrCountFromBottom);
                logIndexFromBottom--;
            }

            logIndex++;

        }//end of while loop

        if (faultyServersWithStatusList.isEmpty()) {
            System.out.println("No faulty servers found");
        }
        //Print only faulty servers Id from faultyServersWithStatusList
        faultyServersWithStatusList.forEach(element -> System.out.println(element.split(" ")[0]));


    }
}
