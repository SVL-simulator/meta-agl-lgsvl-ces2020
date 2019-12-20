FILESEXTRAPATHS_prepend := "${THISDIR}/enactbrowser:"

SRC_URI += " \
  file://disable-fullscreen-button.patch \
  file://enactbrowser-demo-defaults.js \
"

do_compile_prepend() {
  cp ${WORKDIR}/enactbrowser-demo-defaults.js ${S}/samples/enact-based/defaults.js
}