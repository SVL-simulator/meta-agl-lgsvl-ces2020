SRC_URI += " \
  file://html5-launcher-config-demo.json \
"

ICONS_PATH = "${S}/src/images/icons"

do_compile_prepend() {
  cp ${ICONS_PATH}/navigation_inactive.svg ${ICONS_PATH}/agate\ agl\ console_inactive.svg
  cp ${ICONS_PATH}/navigation_active.svg ${ICONS_PATH}/agate\ agl\ console_active.svg
  cp ${ICONS_PATH}/video_inactive.svg ${ICONS_PATH}/youtube_inactive.svg
  cp ${ICONS_PATH}/video_active.svg ${ICONS_PATH}/youtube_active.svg
  cp ${ICONS_PATH}/webbrowser_inactive.svg ${ICONS_PATH}/enact\ browser_inactive.svg
  cp ${ICONS_PATH}/webbrowser_active.svg ${ICONS_PATH}/enact\ browser_active.svg
  cp ${ICONS_PATH}/webbrowser_inactive.svg ${ICONS_PATH}/webgl\ aquarium_inactive.svg
  cp ${ICONS_PATH}/webbrowser_active.svg ${ICONS_PATH}/webgl\ aquarium_active.svg
  cp ${ICONS_PATH}/webbrowser_inactive.svg ${ICONS_PATH}/webgl\ blob_inactive.svg
  cp ${ICONS_PATH}/webbrowser_active.svg ${ICONS_PATH}/webgl\ blob_active.svg
  cp ${WORKDIR}/html5-launcher-config-demo.json ${S}/src/config.json
}
