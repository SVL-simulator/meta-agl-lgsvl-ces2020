DESCRIPTION = "Agate communication server"

require agate-apps.inc

SRC_URI += " \
  file://config-communication-server.xml \
  file://icon-communication-server.png \
  file://agate-communication-server.service \
  file://agate-communication-server \
"

do_compile() {
  # changing the home directory to the working directory, see do_configure
  export HOME=${WORKDIR}

  # build communication-server
  cd ${S}/communication-server
  ${STAGING_BINDIR_NATIVE}/npm --no-optional install
}

do_aglwgt_package()  {
  install -d ${B}/package

  # package copilot app
  install -v -m 644 ${WORKDIR}/config-copilot.xml ${S}/copilot/dist/config.xml
  install -v -m 644 ${WORKDIR}/icon-copilot.png ${S}/copilot/dist/icon.png
  cd ${S}/copilot/dist
  ${STAGING_BINDIR_NATIVE}/zip -r ${B}/package/agate-copilot.wgt *
}

do_install_append() {
  # Ugly hack to start agate-communication-server on systemd
  # Didn't have time to figure out how it should be done in AGL in right way

  install -d ${D}${systemd_user_unitdir}
  install -v -m 644 ${WORKDIR}/agate-communication-server.service ${D}${systemd_user_unitdir}/agate-communication-server.service

  install -d ${D}${sysconfdir}/systemd/user/default.target.wants
  ln -sf ${systemd_user_unitdir}/agate-communication-server.service ${D}${sysconfdir}/systemd/user/default.target.wants
}

do_aglwgt_package()  {
  install -d ${B}/package

  # package communication-server
  install -v -m 644 ${WORKDIR}/config-communication-server.xml ${S}/communication-server/config.xml
  install -v -m 644 ${WORKDIR}/icon-communication-server.png ${S}/communication-server/icon.png
  install -v -m 755 ${WORKDIR}/agate-communication-server ${S}/communication-server/agate-communication-server
  cd ${S}/communication-server
  ${STAGING_BINDIR_NATIVE}/zip -r ${B}/package/agate-communication-server.wgt *
}

FILES_${PN} += "${systemd_user_unitdir}"
