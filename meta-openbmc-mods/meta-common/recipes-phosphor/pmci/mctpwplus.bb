SUMMARY = "MCTP Wrapper Library Plus"
DESCRIPTION = "Implementation of MCTP Wrapper Library Plus"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=615045c30a05cde5c0e924854d43c327"

SRC_URI = "git://git@github.com/Intel-BMC/mctpwplus.git;protocol=ssh;branch=main"
SRCREV = "7a7425ce324497d1199af2cc9ce0e948cc226307"

S = "${WORKDIR}/git"

PV = "1.0+git${SRCPV}"

inherit cmake

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS += " \
    systemd \
    sdbusplus \
    phosphor-logging \
    cli11 \
    "
EXTRA_OECMAKE += "-DYOCTO_DEPENDENCIES=ON"
