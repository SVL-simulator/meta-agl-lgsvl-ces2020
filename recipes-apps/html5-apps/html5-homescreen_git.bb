# Copyright (c) 2018-2019 LG Electronics, Inc.

SUMMARY = "HTML5 Homescreen"
AUTHOR = "Jose Dapena Paz <jose.dapena@lge.com>"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

require html5-apps.inc

RDEPENDS_${PN} += "agl-service-homescreen agl-service-windowmanager agl-service-weather agl-service-network agl-service-bluetooth af-main"

PR = "r0"

SRC_URI = "git://github.com/AGL-web-applications/homescreen.git;protocol=https;branch=master"
SRCREV = "572f34f912c4dad8986ebe4be553b10b41a95299"

do_aglwgt_package() {
    cd ${B}
    ${NPM_BIN} run build
    cp ${B}/package/homescreen.wgt ${B}/html5-homescreen.wgt
}
