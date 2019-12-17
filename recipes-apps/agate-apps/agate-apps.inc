LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

PR = "r0"
SRCREV = "be6f067d41594090f4822c167e7f7f907e7a8be0"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
S = "${WORKDIR}/git"

SRC_URI += "git://github.com/enactjs/agate-apps.git;branch=IAA2019;protocol=https"

DEPENDS += " nodejs nodejs-native zip-native"

inherit aglwgt

do_configure() {
  # changing the home directory to the working directory, the .npmrc will be created in this directory
  export HOME=${WORKDIR}

  ${STAGING_BINDIR_NATIVE}/npm update
  ${STAGING_BINDIR_NATIVE}/npm shrinkwrap

  # access npm registry using http
  ${STAGING_BINDIR_NATIVE}/npm set strict-ssl false
  ${STAGING_BINDIR_NATIVE}/npm config set registry http://registry.npmjs.org/

   # configure cache to be in working directory
  ${STAGING_BINDIR_NATIVE}/npm set cache ${WORKDIR}/npm_cache

  cd ${S}
  ${STAGING_BINDIR_NATIVE}/npm install -g @enact/cli

  # install components deps
  cd ${S}/components
  ${STAGING_BINDIR_NATIVE}/npm install
}

