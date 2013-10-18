function getLocation()
{
  var jsgeos = new Array();	  
  for(var i=0;i&lt;#{homeBean.geoslength};i++) {
	var jsgeo = new Array();	
	jsgeo[0]= #{homeBean.geos[0].city};
	jsgeo[1]=#{homeBean.geos[0].lati};
	jsgeo[2]=#{homeBean.geos[0].longt};
	jsgeo[3]=#{homeBean.geos[0].prio};
	jsgeos[i]=jsgeo;
  }
  alert(jsgeos.length);
}