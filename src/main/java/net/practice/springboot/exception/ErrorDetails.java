package net.practice.springboot.exception;

import java.util.Date;

public class ErrorDetails {
		private Date timestamp;
		private String messsage;
		private String details;
		
		
		public ErrorDetails(Date timestamp, String messsage, String details) {
			super();
			this.timestamp = timestamp;
			this.messsage = messsage;
			this.details = details;
		}
		public Date getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}
		public String getMesssage() {
			return messsage;
		}
		public void setMesssage(String messsage) {
			this.messsage = messsage;
		}
		public String getDetails() {
			return details;
		}
		public void setDetails(String details) {
			this.details = details;
		}
		
}
