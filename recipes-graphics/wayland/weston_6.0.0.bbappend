# Copyright (c) 2019 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
EXTENDPRAUTO_append = "ces2020.1"

SRC_URI += " \
 file://0001-libweston-release-touch-grab-on-touch-up.patch \
"
