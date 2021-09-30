package com.android.kawalcorona.api.response;

import com.google.gson.annotations.SerializedName;

public class DataIndonesiaResponse{

		@SerializedName("meninggal")
		private String meninggal;

		@SerializedName("positif")
		private String positif;

		@SerializedName("sembuh")
		private String sembuh;

		@SerializedName("dirawat")
		private String dirawat;

		@SerializedName("name")
		private String name;

		public String getMeninggal(){
			return meninggal;
		}

		public String getPositif(){
			return positif;
		}

		public String getSembuh(){
			return sembuh;
		}

		public String getDirawat(){
			return dirawat;
		}

		public String getName(){
			return name;
		}

}