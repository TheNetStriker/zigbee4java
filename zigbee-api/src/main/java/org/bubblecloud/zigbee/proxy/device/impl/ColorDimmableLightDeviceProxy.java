/*
   Copyright 2012-2013 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies
   of the Italian National Research Council


   See the NOTICE file distributed with this work for additional
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package org.bubblecloud.zigbee.proxy.device.impl;

import org.bubblecloud.zigbee.ZigbeeConstants;
import org.bubblecloud.zigbee.ZigbeeProxyContext;
import org.bubblecloud.zigbee.network.ZigBeeDevice;
import org.bubblecloud.zigbee.proxy.*;
import org.bubblecloud.zigbee.proxy.cluster.general.Groups;
import org.bubblecloud.zigbee.proxy.cluster.general.LevelControl;
import org.bubblecloud.zigbee.proxy.cluster.general.OnOff;
import org.bubblecloud.zigbee.proxy.cluster.general.Scenes;
import org.bubblecloud.zigbee.proxy.cluster.measureament_sensing.OccupacySensing;
import org.bubblecloud.zigbee.proxy.device.lighting.ColorDimmableLight;
import org.bubblecloud.zigbee.proxy.cluster.impl.api.lighting.ColorControl;

/**
 * @author <a href="mailto:manlio.bacco@isti.cnr.it">Manlio Bacco</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.7.0
 */
public class ColorDimmableLightDeviceProxy extends DeviceProxyBase implements ColorDimmableLight {

    private OnOff onOff;
    private Scenes scenes;
    private Groups groups;
    private LevelControl levelControl;
    private OccupacySensing occupancySensing;
    private ColorControl colorControl;

    public ColorDimmableLightDeviceProxy(ZigbeeProxyContext ctx, ZigBeeDevice zbDevice) throws ZigBeeHAException {

        super(ctx, zbDevice);

        onOff = (OnOff) getCluster(ZigbeeConstants.CLUSTER_ID_ON_OFF);
        scenes = (Scenes) getCluster(ZigbeeConstants.CLUSTER_ID_SCENES);
        groups = (Groups) getCluster(ZigbeeConstants.CLUSTER_ID_GROUPS);
        levelControl = (LevelControl) getCluster(ZigbeeConstants.DEVICE_ID_LEVEL_CONTROL);
        occupancySensing = (OccupacySensing) getCluster(ZigbeeConstants.CLUSTER_ID_OCCUPANCY_SENSING);
        colorControl = (ColorControl) getCluster(ZigbeeConstants.CLUSTER_ID_COLOR_CONTROL);
    }

    final static DeviceDescription DEVICE_DESCRIPTOR = new AbstractDeviceDescription() {

        public int[] getCustomClusters() {
            return ColorDimmableLight.CUSTOM;
        }

        public int[] getMandatoryCluster() {
            return ColorDimmableLight.MANDATORY;
        }

        public int[] getOptionalCluster() {
            return ColorDimmableLight.OPTIONAL;
        }

        public int[] getStandardClusters() {
            return ColorDimmableLight.STANDARD;
        }
    };

    public OnOff getOnOff() {
        return onOff;
    }

    public Scenes getScenes() {
        return scenes;
    }

    public Groups getGroups() {
        return groups;
    }

    public LevelControl getLevelControl() {
        return levelControl;
    }

    public OccupacySensing getOccupacySensing() {
        return occupancySensing;
    }

    public ColorControl getColorControl() {
        return colorControl;
    }

    @Override
    public String getName() {
        return ColorDimmableLight.NAME;
    }

    @Override
    public DeviceDescription getDescription() {
        return DEVICE_DESCRIPTOR;
    }
}