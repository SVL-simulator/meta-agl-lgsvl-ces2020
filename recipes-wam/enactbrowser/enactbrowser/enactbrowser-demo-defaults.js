// Copyright (c) 2019 LG Electronics, Inc.
// SPDX-License-Identifier: LicenseRef-EnactBrowser-Evaluation
//
// You may not use this content except in compliance with the License.
// You may obtain a copy of the License at
//
// https://github.com/webosose/com.webos.app.enactbrowser/blob/master/LICENSE

function getBrowserDefaults() {
    return {
        bookmarks: [
            {url:'http://192.168.1.100:8080', icon:null, title: 'Simulator'},
            {url:'http://192.168.1.101:8080', icon:null, title: 'Dreamview'},
            {url:'http://lgsvlsimulator.com/', icon:null, title: 'LGSVL'},
            {url:'https://webglsamples.org/', icon: null, title: 'webGL samples'},
            {url:'https://www.youtube.com/channel/UChrPZIYAnKEKiQjmPmBwPKA', icon:null, title: 'YouTube'}
        ],
        config: {
            useBuiltInErrorPages: false,
            restorePrevSessionPolicy: 'onlyLastTab', /*OR allTabs*/
            // Limitations for Simple Tab management policy
            simplePolicy: {
                'maxActiveTabs': 1,
                'maxSuspendedTabs': 2
            },
            // Limitations for MemoryManager aware tab policy
            memoryManager: {
                'maxSuspendedNormal': 3,
                'maxSuspendedLow': 1,
                'maxSuspendedCritical': 0
            }
        },
        settings: {
            startupPage: 'newTabPage', /*OR continue OR homePage*/
            homePageUrl: 'https://www.google.com',
            searchEngine: 'Google',
            alwaysShowBookmarks: false,
            privateBrowsing: false,
            siteFiltering: 'off', /*OR whitelist OR blacklist*/
            pinNumber: '0000'
        },
        sitefiltering: {
            whitelist: ['*google*', '*://*yandex*'],
            blacklist: ['*youtube*', '*lenta.ru*']
        }
    };
}
