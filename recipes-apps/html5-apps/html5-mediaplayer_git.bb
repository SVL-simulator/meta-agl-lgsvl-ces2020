# Copyright (c) 2018-2019 LG Electronics, Inc.

SUMMARY = "HTML5 media player"
AUTHOR = "Jose Dapena Paz <jose.dapena@lge.com>"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

require html5-apps.inc

RDEPENDS_${PN} += "agl-service-homescreen agl-service-windowmanager agl-service-mediaplayer af-main"

PR = "r0"

SRC_URI = "git://github.com/AGL-web-applications/mediaplayer.git;protocol=https;branch=master"
SRCREV = "14a55e90e9e5f587c3637933cde438484dde5c17"

do_aglwgt_package() {
    cd ${B}
    ${NPM_BIN} run build
    cp ${B}/package/mediaplayer.wgt ${B}/html5-mediaplayer.wgt
}
