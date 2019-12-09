SUMMARY = "Simple Qt5 Quick application"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PV = "0.1+git${SRCPV}"

DEPENDS += "qttools-native qtbase qtdeclarative qtquickcontrols2"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/dliess/FilterDraw.git"

S = "${WORKDIR}/git"

inherit cmake
EXTRA_OECMAKE += "-DOE_QMAKE_PATH_EXTERNAL_HOST_BINS=${STAGING_DIR_NATIVE}/${bindir}"

do_install() {
      install -d ${D}${bindir}
      install -m 0755 FilterDraw ${D}${bindir}
}
