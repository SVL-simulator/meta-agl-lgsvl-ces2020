FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_remove_intel-corei7-64 = "file://hdmi-a-1-270.cfg"
SRC_URI_remove_intel-corei7-64 = "file://hdmi-a-1-90.cfg"
# Our HDMI plugged panel shows up as "DP-1"
SRC_URI_append_intel-corei7-64 = " file://dp-1-270.cfg"
