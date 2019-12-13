# Copyright (c) 2018-2019 LG Electronics, Inc.

SUMMARY = "HTML5 HVAC"
AUTHOR = "Jose Dapena Paz <jose.dapena@lge.com>"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

RDEPENDS_${PN} += "agl-service-hvac"

require html5-apps.inc

PR = "r0"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/html5-hvac;protocol=https;branch=master"
SRCREV = "a8a5b85c8148743b09607b1abb33081e211f7aa5"

do_aglwgt_package() {
    cd ${B}
    ${NPM_BIN} run build
    cp ${B}/dist/hvac.wgt ${B}
}
