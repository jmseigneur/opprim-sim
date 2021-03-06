// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package eu.musesproject.server.rt2ae;

import eu.musesproject.server.rt2ae.Device;
import eu.musesproject.server.rt2ae.DeviceSecurityState;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

privileged aspect DeviceSecurityState_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "device_id", nullable = false)
    private Device DeviceSecurityState.deviceId;
    
    @Column(name = "devicestate", length = 12)
    @NotNull
    private String DeviceSecurityState.devicestate;
    
    @Column(name = "antivirus")
    @NotNull
    private Integer DeviceSecurityState.antivirus;
    
    @Column(name = "passwordprotection")
    @NotNull
    private Integer DeviceSecurityState.passwordprotection;
    
    @Column(name = "autolock")
    @NotNull
    private Integer DeviceSecurityState.autolock;
    
    @Column(name = "sslprotection")
    @NotNull
    private Integer DeviceSecurityState.sslprotection;
    
    @Column(name = "encryption")
    @NotNull
    private Integer DeviceSecurityState.encryption;
    
    @Column(name = "trackingdevice")
    @NotNull
    private Integer DeviceSecurityState.trackingdevice;
    
    @Column(name = "remotewipe")
    @NotNull
    private Integer DeviceSecurityState.remotewipe;
    
    @Column(name = "vpn")
    @NotNull
    private Integer DeviceSecurityState.vpn;
    
    @Column(name = "time")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "MM")
    private Calendar DeviceSecurityState.time;
    
    public Device DeviceSecurityState.getDeviceId() {
        return deviceId;
    }
    
    public void DeviceSecurityState.setDeviceId(Device deviceId) {
        this.deviceId = deviceId;
    }
    
    public String DeviceSecurityState.getDevicestate() {
        return devicestate;
    }
    
    public void DeviceSecurityState.setDevicestate(String devicestate) {
        this.devicestate = devicestate;
    }
    
    public Integer DeviceSecurityState.getAntivirus() {
        return antivirus;
    }
    
    public void DeviceSecurityState.setAntivirus(Integer antivirus) {
        this.antivirus = antivirus;
    }
    
    public Integer DeviceSecurityState.getPasswordprotection() {
        return passwordprotection;
    }
    
    public void DeviceSecurityState.setPasswordprotection(Integer passwordprotection) {
        this.passwordprotection = passwordprotection;
    }
    
    public Integer DeviceSecurityState.getAutolock() {
        return autolock;
    }
    
    public void DeviceSecurityState.setAutolock(Integer autolock) {
        this.autolock = autolock;
    }
    
    public Integer DeviceSecurityState.getSslprotection() {
        return sslprotection;
    }
    
    public void DeviceSecurityState.setSslprotection(Integer sslprotection) {
        this.sslprotection = sslprotection;
    }
    
    public Integer DeviceSecurityState.getEncryption() {
        return encryption;
    }
    
    public void DeviceSecurityState.setEncryption(Integer encryption) {
        this.encryption = encryption;
    }
    
    public Integer DeviceSecurityState.getTrackingdevice() {
        return trackingdevice;
    }
    
    public void DeviceSecurityState.setTrackingdevice(Integer trackingdevice) {
        this.trackingdevice = trackingdevice;
    }
    
    public Integer DeviceSecurityState.getRemotewipe() {
        return remotewipe;
    }
    
    public void DeviceSecurityState.setRemotewipe(Integer remotewipe) {
        this.remotewipe = remotewipe;
    }
    
    public Integer DeviceSecurityState.getVpn() {
        return vpn;
    }
    
    public void DeviceSecurityState.setVpn(Integer vpn) {
        this.vpn = vpn;
    }
    
    public Calendar DeviceSecurityState.getTime() {
        return time;
    }
    
    public void DeviceSecurityState.setTime(Calendar time) {
        this.time = time;
    }
    
}
