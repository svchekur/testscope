$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/API-Test.feature");
formatter.feature({
  "line": 1,
  "name": "API test",
  "description": "",
  "id": "api-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 375485119,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Should see LIST USERS of all existing users",
  "description": "",
  "id": "api-test;should-see-list-users-of-all-existing-users",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@API"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I get the default list of users for on 1st page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I get the list of all users",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I should see total users count equals to number of user ids",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.iGetTheDefaultListofusers()"
});
formatter.result({
  "duration": 203135826,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iGetTheListOfAllUsers()"
});
formatter.result({
  "duration": 1196337610,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iShouldMatchTotalCount()"
});
formatter.result({
  "duration": 540119148,
  "status": "passed"
});
formatter.after({
  "duration": 10809,
  "status": "passed"
});
formatter.before({
  "duration": 182614,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Should see SINGLE USER data",
  "description": "",
  "id": "api-test;should-see-single-user-data",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 9,
      "name": "@API"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "I make a search for user 3",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I should see following user data",
  "rows": [
    {
      "cells": [
        "first_name",
        "email"
      ],
      "line": 13
    },
    {
      "cells": [
        "Emma",
        "emma.wong@reqres.in"
      ],
      "line": 14
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 25
    }
  ],
  "location": "StepDefinition.iMakeASearchForUser(String)"
});
formatter.result({
  "duration": 80306563,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.IShouldSeeFollowingUserData(DataTable)"
});
formatter.result({
  "duration": 34058211,
  "status": "passed"
});
formatter.after({
  "duration": 11947,
  "status": "passed"
});
formatter.before({
  "duration": 204231,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Should see SINGLE USER NOT FOUND error code",
  "description": "",
  "id": "api-test;should-see-single-user-not-found-error-code",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 16,
      "name": "@API"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "I make a search for user 55",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "I receive error code 404 in response",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "55",
      "offset": 25
    }
  ],
  "location": "StepDefinition.iMakeASearchForUser(String)"
});
formatter.result({
  "duration": 426001841,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 21
    }
  ],
  "location": "StepDefinition.iReceiveErrorCodeInResponse(int)"
});
formatter.result({
  "duration": 907377,
  "status": "passed"
});
formatter.after({
  "duration": 6258,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 22,
  "name": "CREATE a user",
  "description": "",
  "id": "api-test;create-a-user",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 21,
      "name": "@API"
    }
  ]
});
formatter.step({
  "line": 23,
  "name": "I create user with following \u003cName\u003e \u003cJob\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "response should contain following data",
  "rows": [
    {
      "cells": [
        "name",
        "job",
        "id",
        "createdAt"
      ],
      "line": 25
    }
  ],
  "keyword": "Then "
});
formatter.examples({
  "line": 27,
  "name": "",
  "description": "",
  "id": "api-test;create-a-user;",
  "rows": [
    {
      "cells": [
        "Name",
        "Job"
      ],
      "line": 28,
      "id": "api-test;create-a-user;;1"
    },
    {
      "cells": [
        "Peter",
        "Manager"
      ],
      "line": 29,
      "id": "api-test;create-a-user;;2"
    },
    {
      "cells": [
        "Liza",
        "Sales"
      ],
      "line": 30,
      "id": "api-test;create-a-user;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 167253,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "CREATE a user",
  "description": "",
  "id": "api-test;create-a-user;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 21,
      "name": "@API"
    }
  ]
});
formatter.step({
  "line": 23,
  "name": "I create user with following Peter Manager",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "response should contain following data",
  "rows": [
    {
      "cells": [
        "name",
        "job",
        "id",
        "createdAt"
      ],
      "line": 25
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Peter",
      "offset": 29
    },
    {
      "val": "Manager",
      "offset": 35
    }
  ],
  "location": "StepDefinition.iCreateUserWithFollowing(String,String)"
});
formatter.result({
  "duration": 413040287,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iReceiveErrorCodeInResponse(DataTable)"
});
formatter.result({
  "duration": 6814714,
  "status": "passed"
});
formatter.after({
  "duration": 6827,
  "status": "passed"
});
formatter.before({
  "duration": 143360,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "CREATE a user",
  "description": "",
  "id": "api-test;create-a-user;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 21,
      "name": "@API"
    }
  ]
});
formatter.step({
  "line": 23,
  "name": "I create user with following Liza Sales",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "response should contain following data",
  "rows": [
    {
      "cells": [
        "name",
        "job",
        "id",
        "createdAt"
      ],
      "line": 25
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Liza",
      "offset": 29
    },
    {
      "val": "Sales",
      "offset": 34
    }
  ],
  "location": "StepDefinition.iCreateUserWithFollowing(String,String)"
});
formatter.result({
  "duration": 384033806,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iReceiveErrorCodeInResponse(DataTable)"
});
formatter.result({
  "duration": 6648599,
  "status": "passed"
});
formatter.after({
  "duration": 7964,
  "status": "passed"
});
formatter.before({
  "duration": 273066,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "LOGIN - SUCCESSFUL by a user",
  "description": "",
  "id": "api-test;login---successful-by-a-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 32,
      "name": "@API"
    }
  ]
});
formatter.step({
  "line": 34,
  "name": "I login succesfully with following data",
  "rows": [
    {
      "cells": [
        "Email",
        "Password"
      ],
      "line": 35
    },
    {
      "cells": [
        "eve.holt@reqres.in",
        "cityslicka"
      ],
      "line": 36
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.iLoginSuccesfullyWithFollowingData(DataTable)"
});
formatter.result({
  "duration": 369420769,
  "status": "passed"
});
formatter.after({
  "duration": 6258,
  "status": "passed"
});
formatter.before({
  "duration": 155307,
  "status": "passed"
});
formatter.scenario({
  "line": 39,
  "name": "LOGIN - UNSUCCESSFUL by a user",
  "description": "",
  "id": "api-test;login---unsuccessful-by-a-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 38,
      "name": "@API"
    }
  ]
});
formatter.step({
  "line": 40,
  "name": "I login unsuccesfully with following data",
  "rows": [
    {
      "cells": [
        "Email",
        "Password"
      ],
      "line": 41
    },
    {
      "cells": [
        "eve.holt@reqres.in",
        ""
      ],
      "line": 42
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.iLoginUnsuccesfullyWithFollowingData(DataTable)"
});
formatter.result({
  "duration": 241429412,
  "status": "passed"
});
formatter.after({
  "duration": 10808,
  "status": "passed"
});
formatter.before({
  "duration": 141653,
  "status": "passed"
});
formatter.scenario({
  "line": 45,
  "name": "Should see list of users with DELAYED RESPONSE",
  "description": "",
  "id": "api-test;should-see-list-of-users-with-delayed-response",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 44,
      "name": "@API"
    }
  ]
});
formatter.step({
  "line": 46,
  "name": "I wait for user list to load",
  "keyword": "Given "
});
formatter.step({
  "line": 47,
  "name": "I should see that every user has a unique id",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.iWaitForUserListToLoad()"
});
formatter.result({
  "duration": 5239330783,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iShouldSeeThatEveryUserHasAUniqueID()"
});
formatter.result({
  "duration": 75919864,
  "status": "passed"
});
formatter.after({
  "duration": 10809,
  "status": "passed"
});
formatter.uri("src/test/java/SampleTest.feature");
formatter.feature({
  "line": 1,
  "name": "BrightTalk  Sample Test",
  "description": "",
  "id": "brighttalk--sample-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3958925120,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Sample",
  "description": "",
  "id": "brighttalk--sample-test;sample",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@UI"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "I am on the home page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.iAmOnTheHomePage()"
});
formatter.result({
  "duration": 1287723274,
  "status": "passed"
});
formatter.after({
  "duration": 866804452,
  "status": "passed"
});
});