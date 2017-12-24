(function(window, undefined) {
  var dictionary = {
    "cfc8ce98-9b7e-4a1c-8fb4-cf4f9ee7df1b": "companySearchJobSeekerPage",
    "d12245cc-1680-458d-89dd-4f0d7fb22724": "index",
    "b112341d-267a-4530-a31f-53c2af29a3c1": "companyProfilePage",
    "5076a082-b513-401d-b769-d494f76aeec0": "editJobseekerPage",
    "df07b1a5-0990-4e27-ab13-b0ac9e7f5bff": "jobSeekerProfilePage",
    "16c477c4-efcd-473b-ba93-545e3d20c4c0": "editCompanyPage",
    "a91893ad-5a1b-4f0a-9fc9-2c5be7230c02": "registrationAccountPage",
    "43773576-e4a6-40ae-b3eb-c5ee07922f39": "jobSeekerEditResumePage",
    "87db3cf7-6bd4-40c3-b29c-45680fb11462": "960 grid - 16 columns",
    "e5f958a4-53ae-426e-8c05-2f7d8e00b762": "960 grid - 12 columns",
    "f39803f7-df02-4169-93eb-7547fb8c961a": "Template 1",
    "e8708d40-10a0-4095-bb85-bd2a24265b76": "companyBasePage",
    "34cf4625-e41e-421a-a48d-db610044defd": "education",
    "7caab0c7-b9a7-468c-afcb-b04abf142340": "Languages",
    "646842ad-b0ac-46a6-b31f-fb85ff32e685": "jobseekerBasePage",
    "f91e2705-779e-45de-b806-10b9e2ba07c7": "searchJobSeeker_small",
    "4f41e5b1-55a1-4693-ab9e-984738641fdb": "experience",
    "89de89d2-9d7e-4dae-883b-bd133f68db20": "course",
    "4a139bb9-cb5e-4224-bae7-23e5329e9eb8": "recomendation",
    "952ade57-ada3-472c-b7ea-e017f811383f": "searchJobSeeker_Big",
    "ac021a89-e164-4546-9a90-6651e02e86b0": "project",
    "bb8abf58-f55e-472d-af05-a7d1bb0cc014": "default"
  };

  var uriRE = /^(\/#)?(screens|templates|masters|scenarios)\/(.*)(\.html)?/;
  window.lookUpURL = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, url;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      url = folder + "/" + canvas;
    }
    return url;
  };

  window.lookUpName = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, canvasName;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      canvasName = dictionary[canvas];
    }
    return canvasName;
  };
})(window);