package com.hw.airport.config;

public class GUISettings {

  private MasterFrameSettings mFrameSettings;
  private PassengerPanelSettings psngrPnlSettings;
  private CheckInDeskPanelSettings checkInDskPnlSettings;
  private ActiveFlightPanelSettings activFlghtPnlSettings;
  private SimToolBarSettings simToolBrSettings;

  public GUISettings (MasterFrameSettings newMFrameSettings, PassengerPanelSettings newPsngrPnlSettings, CheckInDeskPanelSettings newCheckInDskPnlSettings,
                      ActiveFlightPanelSettings newActiveFlghtPnlSettings, SimToolBarSettings newSimToolBrSettings) {

      this.setMasterFrameSettings(newMFrameSettings);
      this.setPsngrPnlSettings(newPsngrPnlSettings);
      this.setCheckInDskPnlSettings(newCheckInDskPnlSettings);
      this.setActivFlghtPnlSettings(newActiveFlghtPnlSettings);
      this.setSimToolBrSettings(newSimToolBrSettings);
  }

    public MasterFrameSettings getMasterFrameSettings() {
        return mFrameSettings;
    }

    public void setMasterFrameSettings(MasterFrameSettings mFrameSettings) {
        this.mFrameSettings = mFrameSettings;
    }

    public PassengerPanelSettings getPsngrPnlSettings() {
        return psngrPnlSettings;
    }

    public void setPsngrPnlSettings(PassengerPanelSettings psngrPnlSettings) {
        this.psngrPnlSettings = psngrPnlSettings;
    }

    public CheckInDeskPanelSettings getCheckInDskPnlSettings() {
        return checkInDskPnlSettings;
    }

    public void setCheckInDskPnlSettings(CheckInDeskPanelSettings checkInDskPnlSettings) {
        this.checkInDskPnlSettings = checkInDskPnlSettings;
    }

    public ActiveFlightPanelSettings getActivFlghtPnlSettings() {
        return activFlghtPnlSettings;
    }

    public void setActivFlghtPnlSettings(ActiveFlightPanelSettings activFlghtPnlSettings) {
        this.activFlghtPnlSettings = activFlghtPnlSettings;
    }

    public SimToolBarSettings getSimToolBrSettings() {
        return simToolBrSettings;
    }

    public void setSimToolBrSettings(SimToolBarSettings simToolBrSettings) {
        this.simToolBrSettings = simToolBrSettings;
    }
}


