# Copyright (c) 2019 LG Electronics, Inc.

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

RDEPENDS_${PN} += "wam"

inherit cmake aglwgt

SRC_URI = "gitsm://auto-gitlab.lgsvl.net/jose.dapena/html5-remote.git;branch=master;protocol=https"
SRCREV = "e891128464d48c505f56778c4863c52a7c3ab31a"

PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OECMAKE += "\
  -DREMOTE_HTML5_NAME="${PN}" \
  -DREMOTE_HTML5_DESCRIPTION="${SUMMARY}" \
  -DREMOTE_HTML5_URL="${APP_URL}" \
"
