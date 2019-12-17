# Copyright (c) 2018-2019 LG Electronics, Inc.

SUMMARY = "HTML5 Dashboard"
AUTHOR = "Jose Dapena Paz <jose.dapena@lge.com>"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

require html5-apps.inc

RDEPENDS_${PN} += "agl-service-homescreen agl-service-windowmanager agl-service-can-low-level af-main"

PR = "r0"

SRC_URI = "git://github.com/AGL-web-applications/dashboard.git;protocol=https;branch=master"
SRCREV = "70a4b4111d6dc3b9a302bb2ce5ca6c892a8d2e73"

do_aglwgt_package() {
    cd ${B}
    ${NPM_BIN} run build
    cp ${B}/package/dashboard.wgt ${B}/html5-dashboard.wgt
}
