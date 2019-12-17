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
            {url:'https://google.com/', icon:null, title: 'Google'},
            {url:'https://www.automotivelinux.org/', icon:null, title: 'AGL'},
            {url:'https://agl-web-applications.github.io/examples/', icon: null, 'Examples'},
            {url:'http://lgsvl.com/', icon:null, title: 'LGSVL'},
            {url:'https://www.igalia.com/', icon:null, title: 'Igalia'}
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
