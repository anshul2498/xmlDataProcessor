package com.companyname.domain;

public class XmlNode {
	
	private Integer nodeID = null;
	private Integer parentNodeID = null;
	private String nodeName = null;
	private String nodeValue = null;

	public Integer getNodeID() {
		return nodeID;
	}

	public void setNodeID(Integer nodeID) {
		this.nodeID = nodeID;
	}

	public Integer getParentNodeID() {
		return parentNodeID;
	}

	public void setParentNodeID(Integer parentNodeID) {
		this.parentNodeID = parentNodeID;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getNodeValue() {
		return nodeValue;
	}

	public void setNodeValue(String nodeValue) {
		this.nodeValue = nodeValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nodeID == null) ? 0 : nodeID.hashCode());
		result = prime * result + ((nodeName == null) ? 0 : nodeName.hashCode());
		result = prime * result + ((nodeValue == null) ? 0 : nodeValue.hashCode());
		result = prime * result + ((parentNodeID == null) ? 0 : parentNodeID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XmlNode other = (XmlNode) obj;
		if (nodeID == null) {
			if (other.nodeID != null)
				return false;
		} else if (!nodeID.equals(other.nodeID))
			return false;
		if (nodeName == null) {
			if (other.nodeName != null)
				return false;
		} else if (!nodeName.equals(other.nodeName))
			return false;
		if (nodeValue == null) {
			if (other.nodeValue != null)
				return false;
		} else if (!nodeValue.equals(other.nodeValue))
			return false;
		if (parentNodeID == null) {
			if (other.parentNodeID != null)
				return false;
		} else if (!parentNodeID.equals(other.parentNodeID))
			return false;
		return true;
	}

}
