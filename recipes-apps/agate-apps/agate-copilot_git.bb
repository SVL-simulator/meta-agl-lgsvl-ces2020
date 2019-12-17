DESCRIPTION = "Agate copilot app"

require agate-apps.inc

SRC_URI += " \
  file://config-copilot.xml \
  file://icon-copilot.png \
"

RDEPENDS_${PN} += " agate-communication-server"

do_compile() {
  # changing the home directory to the working directory, see do_configure
  export HOME=${WORKDIR}

  # build copilot app
  cd ${S}/copilot
  ${STAGING_BINDIR_NATIVE}/npm install
  ${STAGING_BINDIR_NATIVE}/npm run pack-p
}

do_aglwgt_package()  {
  install -d ${B}/package

  # package copilot app
  install -v -m 644 ${WORKDIR}/config-copilot.xml ${S}/copilot/dist/config.xml
  install -v -m 644 ${WORKDIR}/icon-copilot.png ${S}/copilot/dist/icon.png
  cd ${S}/copilot/dist
  ${STAGING_BINDIR_NATIVE}/zip -r ${B}/package/agate-copilot.wgt *
}
