# Fill wlan dta in
# recipes-connectivity/wpa-supplicant/files/wpa_supplicant-nl80211-wlan0.conf

# Some hints for conf/local.conf configuration
IMAGE_FSTYPES = "tar.gz wic.gz wic.bmap rpi-sdimg"

DISTRO_FEATURES_append = "\
    systemd \
    wifi \
"

DISTRO_FEATURES_remove = "x11"

VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = ""
DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"

#inherit systemd
#SYSTEMD_PACKAGES = "${PN}"

#IMAGE_FEATURES += "ssh-server-dropbear"

IMAGE_INSTALL_append = "\
    liberation-fonts \
    ttf-bitstream-vera \
    openssl \
    openssh-sftp-server \
    linux-firmware-rpidistro-bcm43430 \
"

#DEBUG_BUILD = 1
