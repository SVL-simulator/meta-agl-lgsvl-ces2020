LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

PR = "r0"
SRCREV = "c04e9a34db2c4a2e8248c8f2c652b9b8cb32db73"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
S = "${WORKDIR}/git"

DEPENDS += " zip-native"

inherit aglwgt

SRC_URI += "git://github.com/AGL-web-applications/webapp-samples.git;branch=master;protocol=https"

do_compile() {
  cd ${S}
  make package
}

do_aglwgt_package() {
  cp ${S}/package/*.wgt ${B}/
}

RDEPENDS_${PN} += " \
  af-main \
  agl-service-windowmanager \
  agl-service-homescreen \
  virtual/webruntime \
"
