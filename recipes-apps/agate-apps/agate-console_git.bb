DESCRIPTION = "Agate console app"

require agate-apps.inc

SRC_URI += " \
  file://config-console.xml \
  file://icon-console.png \
"

RDEPENDS_${PN} += " agate-communication-server"

do_compile() {
  # changing the home directory to the working directory, see do_configure
  export HOME=${WORKDIR}

  # build console app
  cd ${S}/console
  ${STAGING_BINDIR_NATIVE}/npm install
  ${STAGING_BINDIR_NATIVE}/npm run pack-p
}

do_aglwgt_package()  {
  install -d ${B}/package

  # package console app
  install -v -m 644 ${WORKDIR}/config-console.xml ${S}/console/dist/config.xml
  install -v -m 644 ${WORKDIR}/icon-console.png ${S}/console/dist/icon.png
  cd ${S}/console/dist
  ${STAGING_BINDIR_NATIVE}/zip -r ${B}/package/agate-console.wgt *
}

