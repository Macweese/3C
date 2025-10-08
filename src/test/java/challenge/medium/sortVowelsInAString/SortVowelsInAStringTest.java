/*
 *
 *     Copyright (C) 2025 Macweese <https://www.github.com/Macweese>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package challenge.medium.sortVowelsInAString;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SortVowelsInAStringTest
{
	private static final Map<String, String> MAP = new HashMap<>();
	static
	{

		MAP.put("j","j");
		MAP.put("o","o");
		MAP.put("u","u");
		MAP.put("W","W");
		MAP.put("Y","Y");
		MAP.put("C","C");
		MAP.put("sB","sB");
		MAP.put("oM","oM");
		MAP.put("UR","UR");
		MAP.put("yW","yW");
		MAP.put("tV","tV");
		MAP.put("BV","BV");
		MAP.put("GX","GX");
		MAP.put("qQ","qQ");
		MAP.put("rTj","rTj");
		MAP.put("VJy","VJy");
		MAP.put("Jpm","Jpm");
		MAP.put("Hoz","Hoz");
		MAP.put("NoI","NIo");
		MAP.put("txE","txE");
		MAP.put("WMn","WMn");
		MAP.put("Pep","Pep");
		MAP.put("Ufph","Ufph");
		MAP.put("YMWm","YMWm");
		MAP.put("luoK","louK");
		MAP.put("uOYF","OuYF");
		MAP.put("GCvE","GCvE");
		MAP.put("OsJG","OsJG");
		MAP.put("ffYO","ffYO");
		MAP.put("VvLi","VvLi");
		MAP.put("hpsr","hpsr");
		MAP.put("KdOC","KdOC");
		MAP.put("wKYK","wKYK");
		MAP.put("MfevW","MfevW");
		MAP.put("Ovumf","Ovumf");
		MAP.put("BiujZ","BiujZ");
		MAP.put("Vqydc","Vqydc");
		MAP.put("MSsxY","MSsxY");
		MAP.put("RZYGB","RZYGB");
		MAP.put("ButoT","BotuT");
		MAP.put("huwVJO","hOwVJu");
		MAP.put("EiSGjF","EiSGjF");
		MAP.put("qNmvCB","qNmvCB");
		MAP.put("PJwMFD","PJwMFD");
		MAP.put("lqnDZd","lqnDZd");
		MAP.put("OECvJo","EOCvJo");
		MAP.put("SMIrCZ","SMIrCZ");
		MAP.put("XSbEDU","XSbEDU");
		MAP.put("DuKYpu","DuKYpu");
		MAP.put("RWmnJR","RWmnJR");
		MAP.put("svyZHG","svyZHG");
		MAP.put("worDCLq","worDCLq");
		MAP.put("zjkrXyo","zjkrXyo");
		MAP.put("pockSUy","pUckSoy");
		MAP.put("FJxBFrc","FJxBFrc");
		MAP.put("CynTtmX","CynTtmX");
		MAP.put("cNXvyfs","cNXvyfs");
		MAP.put("uGlTtJm","uGlTtJm");
		MAP.put("mhnxuKG","mhnxuKG");
		MAP.put("MFXUGRn","MFXUGRn");
		MAP.put("bToFkxsI","bTIFkxso");
		MAP.put("KhZItneb","KhZItneb");
		MAP.put("uXmyQiKn","iXmyQuKn");
		MAP.put("klhsmFEf","klhsmFEf");
		MAP.put("qMjqxFzu","qMjqxFzu");
		MAP.put("dWRYrjDJ","dWRYrjDJ");
		MAP.put("Xnhdhsmi","Xnhdhsmi");
		MAP.put("KZWbhTuZ","KZWbhTuZ");
		MAP.put("kwjkwgHd","kwjkwgHd");
		MAP.put("WDBULyzS","WDBULyzS");
		MAP.put("KqNhkZIL","KqNhkZIL");
		MAP.put("fKDWMIcP","fKDWMIcP");
		MAP.put("fyivjzCB","fyivjzCB");
		MAP.put("UZFDvIzz","IZFDvUzz");
		MAP.put("JVufsFsI","JVIfsFsu");
		MAP.put("VWPVLqfj","VWPVLqfj");
		MAP.put("LclKgdZH","LclKgdZH");
		MAP.put("HUyyHLmU","HUyyHLmU");
		MAP.put("kRgoMFwY","kRgoMFwY");
		MAP.put("VXsWvrkG","VXsWvrkG");
		MAP.put("YSrgBxhWi","YSrgBxhWi");
		MAP.put("ukqefLbop","ekqofLbup");
		MAP.put("FKFlMVlTC","FKFlMVlTC");
		MAP.put("beTXYPiXC","beTXYPiXC");
		MAP.put("qSWNnfBBF","qSWNnfBBF");
		MAP.put("dIKouvvRN","dIKouvvRN");
		MAP.put("RIsbkILck","RIsbkILck");
		MAP.put("dFkBDMJgI","dFkBDMJgI");
		MAP.put("jzwxurrKP","jzwxurrKP");
		MAP.put("hMHxYlKJGR","hMHxYlKJGR");
		MAP.put("OcomHMJhpU","OcUmHMJhpo");
		MAP.put("CuKXuETZYV","CEKXuuTZYV");
		MAP.put("UVlfjjcjRC","UVlfjjcjRC");
		MAP.put("XwstGqFvSS","XwstGqFvSS");
		MAP.put("NfeQyVtsIm","NfIQyVtsem");
		MAP.put("tZsILmCPVR","tZsILmCPVR");
		MAP.put("WOuBLBfIwu","WIOBLBfuwu");
		MAP.put("eHlMkKNpkb","eHlMkKNpkb");
		MAP.put("HTohoWrPDS","HTohoWrPDS");
		MAP.put("NKGNLGYbHZ","NKGNLGYbHZ");
		MAP.put("QstldhLtoD","QstldhLtoD");
		MAP.put("GPElzMJSBi","GPElzMJSBi");
		MAP.put("wXIuuBYfKO","wXIOuBYfKu");
		MAP.put("XCrbJeGBEv","XCrbJEGBev");
		MAP.put("dbBvjbGlNLt","dbBvjbGlNLt");
		MAP.put("lMDjtnIgSOO","lMDjtnIgSOO");
		MAP.put("kXlhgZpGvmO","kXlhgZpGvmO");
		MAP.put("zlCWcYsukvw","zlCWcYsukvw");
		MAP.put("wqSPEmDeutr","wqSPEmDeutr");
		MAP.put("wWShUCSulDT","wWShUCSulDT");
		MAP.put("NuVyGRVuYrP","NuVyGRVuYrP");
		MAP.put("YNPdZkOJLOr","YNPdZkOJLOr");
		MAP.put("lxcnmpRHEHD","lxcnmpRHEHD");
		MAP.put("YNlwYzSQUXh","YNlwYzSQUXh");
		MAP.put("vNYuqfTtWlS","vNYuqfTtWlS");
		MAP.put("lEHSIRIebhb","lEHSIRIebhb");
		MAP.put("OSCDmcNklYK","OSCDmcNklYK");
		MAP.put("XfHOqWnQwDgP","XfHOqWnQwDgP");
		MAP.put("dqEBLvpJpzzT","dqEBLvpJpzzT");
		MAP.put("ppmrMBILqslh","ppmrMBILqslh");
		MAP.put("MrCidZutNMOo","MrCOdZitNMou");
		MAP.put("UvugTzJVHNjR","UvugTzJVHNjR");
		MAP.put("uNTJBUbCdPiN","UNTJBibCdPuN");
		MAP.put("fCYMLLjfIVVT","fCYMLLjfIVVT");
		MAP.put("jRxoTiMIlbNG","jRxITiMolbNG");
		MAP.put("EETDiLBlWthRo","EETDiLBlWthRo");
		MAP.put("HgujSGhMMthtW","HgujSGhMMthtW");
		MAP.put("BDikGpgRNIEqq","BDEkGpgRNIiqq");
		MAP.put("hrNfIDGnxxGJr","hrNfIDGnxxGJr");
		MAP.put("PZZtsiBtvrPJf","PZZtsiBtvrPJf");
		MAP.put("MFnERnlYxzqIj","MFnERnlYxzqIj");
		MAP.put("xzeVbCrdPhErV","xzEVbCrdPherV");
		MAP.put("yeHinwRGFXOlU","yOHUnwRGFXeli");
		MAP.put("sMFYkmFSOBMQc","sMFYkmFSOBMQc");
		MAP.put("WdzYLRSiDRHWD","WdzYLRSiDRHWD");
		MAP.put("mzhkxKEUVeeprI","mzhkxKEIVUepre");
		MAP.put("sgZYrzfYGdiPtF","sgZYrzfYGdiPtF");
		MAP.put("BYDPbQfJZCsezt","BYDPbQfJZCsezt");
		MAP.put("MoITSkzcSJlQqt","MIoTSkzcSJlQqt");
		MAP.put("upPqfGgOjERBfU","EpPqfGgOjURBfu");
		MAP.put("kDdlFLnXHNiTWt","kDdlFLnXHNiTWt");
		MAP.put("VGpDtBPYmOdguH","VGpDtBPYmOdguH");
		MAP.put("GseHtyUzVeCBhfY","GsUHtyezVeCBhfY");
		MAP.put("ieBLbNKKvMGwgyJ","eiBLbNKKvMGwgyJ");
		MAP.put("CMUZuVTFwLsKujF","CMUZuVTFwLsKujF");
		MAP.put("dRWdfvCvDyzoFJm","dRWdfvCvDyzoFJm");
		MAP.put("LcUNrvPlfbqDFcQ","LcUNrvPlfbqDFcQ");
		MAP.put("rFvKrtZIKMROrFR","rFvKrtZIKMROrFR");
		MAP.put("rLCRdhfpBWwbVcR","rLCRdhfpBWwbVcR");
		MAP.put("rXDKnLveGFVkSmU","rXDKnLvUGFVkSme");
		MAP.put("dMrWfWOYwmlKPNd","dMrWfWOYwmlKPNd");
		MAP.put("UObEgyTJcbNuFPS","EObUgyTJcbNuFPS");
		MAP.put("MVsMKFuyNjkqegZ","MVsMKFeyNjkqugZ");
		MAP.put("EcSZqEjzGxTTeCr","EcSZqEjzGxTTeCr");
		MAP.put("bJzbgnlEESfQHWRl","bJzbgnlEESfQHWRl");
		MAP.put("WfUjONgoKLZZGgmW","WfOjUNgoKLZZGgmW");
		MAP.put("lfWIVTKyHIWMQTQg","lfWIVTKyHIWMQTQg");
		MAP.put("GPGSDCstzcQGotpo","GPGSDCstzcQGotpo");
		MAP.put("IhqMfMxrxzKPOTzk","IhqMfMxrxzKPOTzk");
		MAP.put("VyKBslWkXpWvmlgp","VyKBslWkXpWvmlgp");
		MAP.put("CJdOYjnFdzXwMOlS","CJdOYjnFdzXwMOlS");
		MAP.put("IIJyjUkJMpEQgYKD","EIJyjIkJMpUQgYKD");
		MAP.put("QBWNETULtsKPoBlr","QBWNETULtsKPoBlr");
		MAP.put("SkGYTIiUTFYRLESrM","SkGYTEIUTFYRLiSrM");
		MAP.put("hGpSNHHKLohrQNUhm","hGpSNHHKLUhrQNohm");
		MAP.put("wohwjIJVnlzyXhmgdL","wIhwjoJVnlzyXhmgdL");
		MAP.put("oyQXmtsGdcvYoVhFCJ","oyQXmtsGdcvYoVhFCJ");
		MAP.put("dcwsirvSIeDkSHcXnkN","dcwsIrvSeiDkSHcXnkN");
		MAP.put("IQnufJGGvwcOkSOrnYs","IQnOfJGGvwcOkSurnYs");
		MAP.put("UMZkJXBWTYXZkXxVqDG","UMZkJXBWTYXZkXxVqDG");
		MAP.put("xPPGvEMQtrTULVDbxnI","xPPGvEMQtrTILVDbxnU");
		MAP.put("voxZgGZKmdozCMOoxdYU","vOxZgGZKmdUzCMooxdYo");
		MAP.put("sMwMFtYGrnGRqzVDhBRx","sMwMFtYGrnGRqzVDhBRx");
		MAP.put("CpPPJiIwyDuUGGYrXvfr","CpPPJIUwyDiuGGYrXvfr");
		MAP.put("MNkiLsPbyczTzOGXBpFY","MNkOLsPbyczTziGXBpFY");
		MAP.put("dqGtjWXpJjpIwveOxWObc","dqGtjWXpJjpIwvOOxWebc");
		MAP.put("KBSvSCfFhdSllYspBJfkG","KBSvSCfFhdSllYspBJfkG");
		MAP.put("eZqphVhEugzRqmSWwidGw","EZqphVheigzRqmSWwudGw");
		MAP.put("wcRtekLeQuOBdcmuVmowT","wcRtOkLeQeoBdcmuVmuwT");
		MAP.put("wrwpkOvYSlsBqBQINQJSzc","wrwpkIvYSlsBqBQONQJSzc");
		MAP.put("pYeLzrtPbuobDYxsSJohdT","pYeLzrtPboobDYxsSJuhdT");
		MAP.put("EpKVyQtKhfGbFLldTOUvvX","EpKVyQtKhfGbFLldTOUvvX");
		MAP.put("NmtLJVqVDurBfsulZsgiPT","NmtLJVqVDirBfsulZsguPT");
		MAP.put("zyFDLsSnTczhELoLqSkiPs","zyFDLsSnTczhELiLqSkoPs");
		MAP.put("RVGrRBiIcPKgQMnmKMxDHSZ","RVGrRBIicPKgQMnmKMxDHSZ");
		MAP.put("XxCdmFJDQqSxIVzjXCUgrjY","XxCdmFJDQqSxIVzjXCUgrjY");
		MAP.put("EEZtIPolILSdCgXVYvthftK","EEZtIPIloLSdCgXVYvthftK");
		MAP.put("SFQVxtPFTjDpYgwjejXjTwtd","SFQVxtPFTjDpYgwjejXjTwtd");
		MAP.put("neCjguGMuBIkgDYtreXHdsHw","nICjgeGMeBukgDYtruXHdsHw");
		MAP.put("iqxVbzGSzGcUvyCcOEiyInFM","EqxVbzGSzGcIvyCcOUiyinFM");
		MAP.put("rhjloLsERzcPSKjpwQUmdiDC","rhjlELsURzcPSKjpwQimdoDC");
		MAP.put("HYjzqofsFqqLDSKgkBXRwNEu","HYjzqEfsFqqLDSKgkBXRwNou");
		MAP.put("rpcRVxPxKxgfFSOFsbXMsIgVp","rpcRVxPxKxgfFSIFsbXMsOgVp");
		MAP.put("iBOoBHrIfMMBTiJokXwQiGDXI","IBIOBHrifMMBTiJikXwQoGDXo");
		MAP.put("mihEdsJVMNCjueEweURpcdRpvX","mEhEdsJVMNCjUeewiuRpcdRpvX");
		MAP.put("myegrcWWCxvrRuBqTLRqGpnWFz","myegrcWWCxvrRuBqTLRqGpnWFz");
		MAP.put("RqlweciXgzGeQhrzOKZjWwTLOL","RqlwOcOXgzGeQhrzeKZjWwTLiL");
		MAP.put("NYfyjsbzCWoTXLfLMeVqCUeVcbg","NYfyjsbzCWUTXLfLMeVqCeoVcbg");
		MAP.put("vbOUSBkMcyZwoKPzPJtIyQkGLJi","vbIOSBkMcyZwUKPzPJtiyQkGLJo");
		MAP.put("oehPoFPMpsXBJEwRonmhkywiVmny","EehPiFPMpsXBJowRonmhkywoVmny");
		MAP.put("RttHsfzGEHCXEovIRmioZlJIkSGvn","RttHsfzGEHCXEIvIRmioZlJokSGvn");
		MAP.put("ixiURktcegitOcbhhIwpftVBNDTtG","IxOURktcegiticbhhiwpftVBNDTtG");
		MAP.put("ounTLhjCDlRxPSkEvDFcJtybUfKOI","EInTLhjCDlRxPSkOvDFcJtybUfKou");
		MAP.put("TINKcNJkRUbqBPyBWQmKpZUeoLfSOI","TINKcNJkRIbqBPyBWQmKpZOUULfSeo");
		MAP.put("YGOzXSsRYnrJWzQOxQXnMHdINNGxkt","YGIzXSsRYnrJWzQOxQXnMHdONNGxkt");
		MAP.put("JDUOYBXpuwPnjnVmeZJFmUDDobgqPL","JDOUYBXpUwPnjnVmeZJFmoDDubgqPL");
		MAP.put("tmGgkdgqofcJeWeDqUhvjGiFpXKtgI","tmGgkdgqIfcJUWeDqehvjGiFpXKtgo");
		MAP.put("WVXSiIkOGwsxtTxmofxJsUsNucFHTQg","WVXSIOkUGwsxtTxmifxJsosNucFHTQg");
		MAP.put("hCeGDZFvLWpYzvLzCcqEQzuTBxRUuvp","hCEGDZFvLWpYzvLzCcqUQzeTBxRuuvp");
		MAP.put("txjYnRTQrBMRQZNrgIMzJkCpsBTygPu","txjYnRTQrBMRQZNrgIMzJkCpsBTygPu");
		MAP.put("WqKftRDgCsEdcktEBgqLILkqmDFDRjF","WqKftRDgCsEdcktEBgqLILkqmDFDRjF");
		MAP.put("DprIFVuloRVVFdlrCDTXdViKdHCQtoie","DprIFVeliRVVFdlrCDTXdViKdHCQtoou");
		MAP.put("tSpYWgSsqciVjDZNOOqwLmShiDTVYxee","tSpYWgSsqcOVjDZNOeqwLmSheDTVYxii");
		MAP.put("beoBPkXoPFJrSmesSXnUjdflkbzwkyku","bUeBPkXePFJrSmosSXnojdflkbzwkyku");
		MAP.put("MpFdvLtCBKktLZGJCBvELQUeXULzlRRwf","MpFdvLtCBKktLZGJCBvELQUUXeLzlRRwf");
		MAP.put("utCbQOmzVTouorULjDkgjoDNoDcERutDik","EtCbQOmzVTUioroLjDkgjoDNoDcuRutDuk");
		MAP.put("IZjjzVXZgxYKZRejhLzDYpOfDkhGJbcdhm","IZjjzVXZgxYKZROjhLzDYpefDkhGJbcdhm");
		MAP.put("dnXxjTETXqKFSPqdQcRzlJwHzsmitYBwIM","dnXxjTETXqKFSPqdQcRzlJwHzsmItYBwiM");
		MAP.put("rjnBpeZGlDTPCZcVRKlqXBpgZVWkIKIOIi","rjnBpIZGlDTPCZcVRKlqXBpgZVWkIKIOei");
		MAP.put("EwplZxQMlzvZxWyiwlsYLhCTnPMTRsEyEjU","EwplZxQMlzvZxWyEwlsYLhCTnPMTRsEyUji");
		MAP.put("ddKhoChoHUhopIdQJBtOhexJLDLZxEVLNKO","ddKhEChIHOhOpUdQJBtehoxJLDLZxoVLNKo");
		MAP.put("xczqSIVxzxXEzxstUKVDjqsStxJFFWPHTEF","xczqSEVxzxXEzxstIKVDjqsStxJFFWPHTUF");
		MAP.put("KIdTgFiYumFsORzzCWSZLvDEqHKzHHpxFxd","KEdTgFIYOmFsiRzzCWSZLvDuqHKzHHpxFxd");
		MAP.put("iGUGFCVIXTCXBXsUkizJMdcCGoujbqrRYpIE","EGIGFCVIXTCXBXsUkUzJMdcCGiijbqrRYpou");
		MAP.put("xeKPrHVdbshTBvQdBvjIpBSNfLWomzVBUrcx","xIKPrHVdbshTBvQdBvjUpBSNfLWemzVBorcx");
		MAP.put("xEsrrrJzFuymTsZwWBtfYKxiTIgOYflSkoll","xEsrrrJzFIymTsZwWBtfYKxOTigoYflSkull");
		MAP.put("PFeyUwrbJKSWgKFrbuoYtMZhnBZloyqdpHdv","PFUyewrbJKSWgKFrbooYtMZhnBZluyqdpHdv");
		MAP.put("RiSsizsqMCGBgGjJwpkwYCWdUgekizeozGeoB","RUSsezsqMCGBgGjJwpkwYCWdegekiziizGooB");
		MAP.put("QdjEqzzeOyiRxrPcOQPVFGIpXHZzJMyQiBxDLR","QdjEqzzIOyORxrPceQPVFGipXHZzJMyQiBxDLR");
		MAP.put("TwbummvtfvugicOHkEXBBQvkuvSwIDyFqdXhpB","TwbEmmvtfvIgOciHkuXBBQvkuvSwuDyFqdXhpB");
		MAP.put("ohKlzwDOVfqKIrhEfVRNBGzvcLKdxXPQdxPeYX","EhKlzwDIVfqKOrhefVRNBGzvcLKdxXPQdxPoYX");
		MAP.put("fyroHBXyoISJXePTOhFDNHiXuvzzOXDpFxxDGKw","fyrIHBXyOOSJXePTihFDNHoXovzzuXDpFxxDGKw");
		MAP.put("dUyXVuBkeXCjYQgyOWTSrEFfcqvXHcLTtYftzKn","dEyXVOBkUXCjYQgyeWTSruFfcqvXHcLTtYftzKn");
		MAP.put("GomZBmIOFTcMNSoINvGTrxWXHwvSRUmrXdihZdg","GImZBmIOFTcMNSUiNvGTrxWXHwvSRomrXdohZdg");
		MAP.put("SeQNMisSjpWzhwOYTZvXlMIdgWcMomVXgKgZoUm","SIQNMOsSjpWzhwUYTZvXlMedgWcMimVXgKgZoom");
		MAP.put("ilPDVdjIMZvuCCBvBJCjOWPKXqpfPxfgYcBbwtx","IlPDVdjOMZviCCBvBJCjuWPKXqpfPxfgYcBbwtx");
		MAP.put("FtKstoEwlVQIOWChTYCNhSuINTeOtDLgGjXpFBkO","FtKstEIwlVQIOWChTYCNhSOONTeotDLgGjXpFBku");
		MAP.put("zVWUnfpYHxwmhcUDoLScvjbIxKQKhygXBqEhsRvx","zVWEnfpYHxwmhcIDULScvjbUxKQKhygXBqohsRvx");
		MAP.put("TKqNGqPYsjUDIBJreOcpbpbLdbsXjrxkswxWndBB","TKqNGqPYsjIDOBJrUecpbpbLdbsXjrxkswxWndBB");
		MAP.put("FupTpDWQcMpnzIHMsBtobjQzoJkiVLZNJrFnJBJd","FIpTpDWQcMpnziHMsBtobjQzoJkuVLZNJrFnJBJd");
		MAP.put("SRDXYOuQRjCucqETkeuUkEWylXeDyLnSnThkmDPJo","SRDXYEEQRjCOcqUTkeeokuWylXuDyLnSnThkmDPJu");
		MAP.put("mCiFLEZTsTzRijCxQvsGRlGpEDMsFhNPHpissPdzgV","mCEFLEZTsTzRijCxQvsGRlGpiDMsFhNPHpissPdzgV");
		MAP.put("FLSKDxxIpDSeCsiIRhNOTCPWwMntCEqGZVnOETNeDB","FLSKDxxEpDSECsIIRhNOTCPWwMntCOqGZVneeTNiDB");
		MAP.put("REDRQBZYouFwXmTkMYgGCoJWSuBiRXLUvNJpPFJtcqDlhM","REDRQBZYUiFwXmTkMYgGCoJWSoBuRXLuvNJpPFJtcqDlhM");
		MAP.put("LYPQOWpnTnRSbKMrZHnzzdEhLcgkYNLffHZWeevGIDCLmz","LYPQEWpnTnRSbKMrZHnzzdIhLcgkYNLffHZWOevGeDCLmz");
		MAP.put("meXvGoJPtjxmoEMDblbbwDOQzDOjedJNghWmYqVsQXItiu","mEXvGIJPtjxmOOMDblbbwDeQzDejidJNghWmYqVsQXotou");
		MAP.put("SjkPMfPGeyESfpkmVuqYsdrwlrcDGWgrgPOzfEbUXdFyPu","SjkPMfPGEyESfpkmVOqYsdrwlrcDGWgrgPUzfebuXdFyPu");
		MAP.put("XPJRmEjKoBUglesGjVqTecOmmGNDxEoiNZpwkZFHpTLppQr","XPJRmEjKEBOglUsGjVqTecemmGNDxiooNZpwkZFHpTLppQr");
		MAP.put("iIIKNPxoTlqxVCbgYtxHlRsrMtuVrKCjKwVcCqkkRpmILBO","IIIKNPxOTlqxVCbgYtxHlRsrMtiVrKCjKwVcCqkkRpmoLBu");
		MAP.put("xRmEMstwTpxBOrFQWFeGPNXfkWJqMpNvJOxsTFZbNRCSKoR","xRmEMstwTpxBOrFQWFOGPNXfkWJqMpNvJexsTFZbNRCSKoR");
		MAP.put("eLGidWDWdNjvEcgGsrcXpVCQqtMRhjiKdPIRjgHObvzYUUzlT","ELGIdWDWdNjvOcgGsrcXpVCQqtMRhjUKdPURjgHebvzYiizlT");
		MAP.put("ieyoWkMntiIGptdUsMyEcCkDVuMKUIRrqxpTmEGENWRXxKdIz","EEyEWkMntIIGptdIsMyUcCkDVUMKeiRrqxpTmiGoNWRXxKduz");
		MAP.put("pJVEDizBgnouyPxxkKXolSUgNcugcVEHcRwjnpvldMKyysWjxky","pJVEDEzBgnUiyPxxkKXolSogNcugcVuHcRwjnpvldMKyysWjxky");
		MAP.put("wiEYMXZblTHUKEbxrDHhnsjhXUNWUtFkJwPbHHtzVKHxhfKXSLv","wEEYMXZblTHUKUbxrDHhnsjhXUNWitFkJwPbHHtzVKHxhfKXSLv");
		MAP.put("jckFKMyCTnMYmPIFuqoxOBPeHJFEjFXEQDYqycZrPbdPMOODbJqPMk","jckFKMyCTnMYmPEFEqIxOBPOHJFOjFXeQDYqycZrPbdPMouDbJqPMk");
		MAP.put("OfWKnunworSiBZLEZrEJmCNoPiTKdYUcmIgWicplEWKBQliSxpGKYM","EfWKnEnwErSIBZLOZrUJmCNiPiTKdYicmigWocploWKBQluSxpGKYM");
		MAP.put("YRCwFrSWBdsUdHUBLLxXCJhvfKLdzwFKCbdPWZFuyxOMQCPmBcYWtVm","YRCwFrSWBdsOdHUBLLxXCJhvfKLdzwFKCbdPWZFUyxuMQCPmBcYWtVm");
		MAP.put("zVNUzqCFeLxGHMfoYtxYSevnwlhmXluCIgpgCBlPoHkXKVhQCwtwEpO","zVNEzqCFILxGHMfOYtxYSUvnwlhmXleCegpgCBlPoHkXKVhQCwtwopu");
		MAP.put("lzYYfDYKwOjyQVijonMuFCtSFKHqFJNIDYNHeLSfNSmFEyeOTgIbfEk","lzYYfDYKwEjyQVEjInMIFCtSFKHqFJNODYNHOLSfNSmFeyeiTgobfuk");
		MAP.put("uHuCplmhNtjeYfBtldGBPiGOVDEGznnHJkrjrOvtlRDpSrLCYbLEKybp","EHECplmhNtjOYfBtldGBPOGeVDiGznnHJkrjruvtlRDpSrLCYbLuKybp");
		MAP.put("YKyxqHyDCNPiHkBuBEcGuRFZLnXBUDcHuFDngZWYRZgGbTWYUhnsFNPwp","YKyxqHyDCNPEHkBUBUcGiRFZLnXBuDcHuFDngZWYRZgGbTWYuhnsFNPwp");
		MAP.put("mROpUCJTDPZmVEzOdDftsgrkIykXsMNktYeovhzJrjTVmpsRyEwfnycHzp","mREpECJTDPZmVIzOdDftsgrkOykXsMNktYUevhzJrjTVmpsRyowfnycHzp");
		MAP.put("hQvIdZyPwZwTwxYpngMBeBRSdZnCOBPjXhovxBxdJeNOOJnFQOZqzlYdyL","hQvIdZyPwZwTwxYpngMBOBRSdZnCOBPjXhOvxBxdJONeeJnFQoZqzlYdyL");
		MAP.put("KmkRcbmrKBtWLruWZGTQETzrRPILblEUwSuMuIwVtjJuYkTJeffONyzUds","KmkRcbmrKBtWLrEWZGTQETzrRPILblIOwSUMUewVtjJuYkTJuffuNyzuds");
		MAP.put("oCKXZOKjgsheTyHYyGVshYvXkxHpgFtQwfHeYxQrBmRRXWBTQblenfwGvsYj","OCKXZeKjgsheTyHYyGVshYvXkxHpgFtQwfHeYxQrBmRRXWBTQblonfwGvsYj");
		MAP.put("WPzjVZndKvdJrQykgFHpNwzQGnWTiBUGduByJmmyLZfBxYvFxRoLtvMTxLuz","WPzjVZndKvdJrQykgFHpNwzQGnWTUBiGdoByJmmyLZfBxYvFxRuLtvMTxLuz");
		MAP.put("qiruRmmrhJQjFdhdKRZgOnLFvuKpxrOTOxSTrRVHwPWPsrpfORMvZbLMJINK","qIrORmmrhJQjFdhdKRZgOnLFvOKpxrOTixSTrRVHwPWPsrpfuRMvZbLMJuNK");
		MAP.put("eNhTBBHtMKxLcqkswvuOuEkCRWreFujZtBvHdgtyrWHXmrgeXjqqiBeTOrXY","ENhTBBHtMKxLcqkswvOOeekCRWreFejZtBvHdgtyrWHXmrgiXjqquBuTurXY");
		MAP.put("hijwhZQSFMkNkqxHbCQGfmSGpPbjdsxVvEwIROonEoKZDxZjmKSWSHWFQjoj","hEjwhZQSFMkNkqxHbCQGfmSGpPbjdsxVvEwIROinooKZDxZjmKSWSHWFQjoj");
		MAP.put("eqhHNbEsrycSbgGjeQwIXLsvgjGMohphPSiwoBXDbGcmtiNYIugHQOFtRWpqx","EqhHNbIsrycSbgGjIQwOXLsvgjGMehphPSewiBXDbGcmtiNYoogHQuFtRWpqx");
		MAP.put("ediWUZDiWidViRiInEIwSpDCOXVLGkwwXJSNozHKQDtYitkJmQiJdNXUeNMbk","EdIWIZDOWUdVUReeniiwSpDCiXVLGkwwXJSNizHKQDtYitkJmQiJdNXioNMbk");
		MAP.put("KsNJUXfPgBXnmecJOnnBXucLdxpoZOnMboMfStrgOBKPqLJvBxdyZPClxsWXmh","KsNJOXfPgBXnmOcJOnnBXUcLdxpeZonMboMfStrguBKPqLJvBxdyZPClxsWXmh");
		MAP.put("dsDKJEtMsoMknQZgeGhnOTLjlZPPBpBQFfzgyjTtnNTxIdSHqnuhgFGWrtCMic","dsDKJEtMsIMknQZgOGhneTLjlZPPBpBQFfzgyjTtnNTxidSHqnohgFGWrtCMuc");
		MAP.put("SzbYejyRllXZgxqxRpYZujyBTWyZIefMIQgmicIZKelsQpPeILBDJrlziVNoigj","SzbYIjyRllXZgxqxRpYZIjyBTWyZIIfMeQgmeceZKelsQpPiiLBDJrlziVNougj");
		MAP.put("xSUlLbqgiOePYwgGQJvVMYzWbzXileiCfXPrczjRgbJxMpgvVSxdHTNGoYnZMSmT","xSOlLbqgUeePYwgGQJvVMYzWbzXiliiCfXPrczjRgbJxMpgvVSxdHTNGoYnZMSmT");
		MAP.put("ptckbBYdodmiTisMsiECNZeLlcmFOBdiJIhuvkJHEWCzpbmietsUBcNFmhGNMXtW","ptckbBYdEdmETIsMsOUCNZeLlcmFeBdiJihivkJHiWCzpbmiotsuBcNFmhGNMXtW");
		MAP.put("YwBQViDVdvyCvHTtvqHuDCMbTZRjnoGoRghHYwGsZVIkCztZOLjMOYJBiybDSkGYt","YwBQVIDVdvyCvHTtvqHODCMbTZRjnOGiRghHYwGsZVikCztZoLjMoYJBuybDSkGYt");
		MAP.put("CXeUcXHiVzkhDcqVWzYKBBrCveneGhMfhLEyTkXhBMCnVidEhjjrZEgXQywJZLdHm","CXEEcXHEVzkhDcqVWzYKBBrCvUneGhMfhLeyTkXhBMCnVedihjjrZigXQywJZLdHm");
		MAP.put("MqBuFCognRosYfFsWRioCLDdWtmpfZkwYhvXXXXguGDWJyzkKiBCHKOCHZpPseJeBKtf","MqBOFCegnResYfFsWRiiCLDdWtmpfZkwYhvXXXXgoGDWJyzkKoBCHKoCHZpPsuJuBKtf");
		MAP.put("rGDhEtJbKrlqxeyKiIfoSSEkBZsxBshtiDTOQYqDkEMhdsVZeFSGLHIcdFYNqXoeQour","rGDhEtJbKrlqxEyKEIfISSOkBZsxBshteDTeQYqDkeMhdsVZiFSGLHicdFYNqXooQour");
		MAP.put("GqGBbKgfQMsfBGkBNzmYvqCdkehPCCnbrBIpGzImDEPGCIsodwHitwgyEkiHowUEFuxzq","GqGBbKgfQMsfBGkBNzmYvqCdkEhPCCnbrBEpGzEmDIPGCIsIdwHUtwgyekiHiwooFuxzq");
		MAP.put("WkzQHNOnEjtYRMuoYNNYMJrGMnElUxngVuOUOiqhwwcoqsvkhwffqdVIXhmWZzGpfJELq","WkzQHNEnEjtYRMEIYNNYMJrGMnOlOxngVOUUioqhwwcoqsvkhwffqdVuXhmWZzGpfJuLq");
		MAP.put("exuCGnFIehpYmlnKdeTUneNORUXELBZoTgMmbSsBGhqnSIOibisdxppPqEjZRlRcqxmKMc","ExECGnFIIhpYmlnKdOTOnUNUReXeLBZeTgMmbSsBGhqnSeiibosdxppPqujZRlRcqxmKMc");
		MAP.put("oItBJUcLBXvgeykFrmvuFEzGmMeryQnbkxUJZrJpUqmcBtdlXZFFPXiBhSywYzQGMWNBit","EItBJUcLBXvgUykFrmvUFezGmMeryQnbkxiJZrJpiqmcBtdlXZFFPXoBhSywYzQGMWNBut");
		MAP.put("nWEjmmWWuzEhkseIfRlKJxEbqGDXVupZeQOwbBemkedQOBiHvSiCvZlNzKjgPXdvggoruM","nWEjmmWWEzEhksIOfRlKJxObqGDXVepZeQewbBemkidQiBoHvSuCvZlNzKjgPXdvgguruM");
		MAP.put("ukDDISkooIJZGrwSLWlrifHWelyTFrufKSdjBonLHTZbbSzyxeVIlbMmrFONggugVOPlkxH","IkDDISkIOOJZGrwSLWlrefHWelyTFrifKSdjBonLHTZbbSzyxoVolbMmrFuNggugVuPlkxH");
		MAP.put("phTjjuxwvwpiyerfLymvZOVSDBVZzpLXIjwTHRIjKohjVUftcTQOEdNOBWTWhcVmShDPfxlKJ","phTjjExwvwpIyIrfLymvZOVSDBVZzpLXOjwTHROjKUhjVeftcTQiodNuBWTWhcVmShDPfxlKJ");
		MAP.put("IoVzVDesSSIWhUfyUFosfrnhCErRPUOwtfUWctxpPhLjVJPPstSDfZmsMcXgiEMPhWjzttevO","EEVzVDIsSSIWhOfyOFUsfrnhCUrRPUUwtfeWctxpPhLjVJPPstSDfZmsMcXgeiMPhWjzttovo");
		MAP.put("sGLxtHCChjzxsYtQKmsxcQHnDSuTDctSFEgSUZGMGPyHlnwWsRpHlqzxTcZBpqrxYWzUNtWkVlsG","sGLxtHCChjzxsYtQKmsxcQHnDSETDctSFUgSUZGMGPyHlnwWsRpHlqzxTcZBpqrxYWzuNtWkVlsG");
		MAP.put("CtskpSyKJVeBovmvFBPJwonQZNqJdGNqgzzyETjjsIVjdiTOBgfebzfXBEftYQtdoXgJmEzJJUyi","CtskpSyKJVEBEvmvFBPJwEnQZNqJdGNqgzzyITjjsOVjdUTeBgfebzfXBiftYQtdiXgJmozJJoyo");
		MAP.put("VjXhFokVXsNXhIhOnbhJTlBbJMhLFRWbPTYxiUWrTThbSCJSOviOjgOoClQSyWKUOTQXUqWyWzwhGl","VjXhFIkVXsNXhOhOnbhJTlBbJMhLFRWbPTYxOOWrTThbSCJSOvUUjgUiClQSyWKioTQXoqWyWzwhGl");
		MAP.put("XQpgZyBKtkuOCwQKUnBtvZHzHcigEDHsvnfjbrTPEBMyEIgUfXnFROONUdpvTDcwUHutbMHCDkJfYB","XQpgZyBKtkEECwQKEnBtvZHzHcIgODHsvnfjbrTPOBMyOUgUfXnFRUUNidpvTDcwuHutbMHCDkJfYB");
		MAP.put("qZgRGUcZRmwLwucZZNjzLxzYCYBFLxGESlOeBkEDfGsczQBMcCiwIQpGuxjLIcUFkOlMkPpWtwHMYYmk","qZgRGEcZRmwLwEcZZNjzLxzYCYBFLxGISlIOBkODfGsczQBMcCUwUQpGexjLicuFkulMkPpWtwHMYYmk");
		MAP.put("FkyVnfiSwbBzwuXuDKMRBlkcWzjevixdllkdHjpkTxvrobgmcgZVDdxZhmiIDPxrkJzYqKcZMEHQfQFb","FkyVnfESwbBzwIXeDKMRBlkcWzjivixdllkdHjpkTxvribgmcgZVDdxZhmouDPxrkJzYqKcZMuHQfQFb");
		MAP.put("fjQuolzkDRdeGxFHGrPSSufFzwdYkDOuogBXeJqHmzERPZcLJxSThSkKeVljdQbzXFhGBlNSdjrFrlWDL","fjQEOlzkDRdeGxFHGrPSSefFzwdYkDeoogBXuJqHmzuRPZcLJxSThSkKuVljdQbzXFhGBlNSdjrFrlWDL");
		MAP.put("vYgSOcVZZZIEmXTkxVQIkgoCVHtXYMeQhtMBCgnzBMUhKlMRzrECcgqRjgIPeRIKUxOJRRZtTFvQMtZlrPyX","vYgSEcVZZZEImXTkxVQIkgICVHtXYMIQhtMBCgnzBMOhKlMRzrOCcgqRjgUPUReKexoJRRZtTFvQMtZlrPyX");
		MAP.put("odcSVXHKYjgkioUozQEJYxhYSqdXYkqeiNlGFWjYPtQtQkNCtXBkfvTqtHilRGkQNixUqQQUesUusVDXxyDM","EdcSVXHKYjgkUUUUzQeJYxhYSqdXYkqeiNlGFWjYPtQtQkNCtXBkfvTqtHilRGkQNixiqQQoosousVDXxyDM");
		MAP.put("NxHKYZuJejifqyWVTZmhXvnHXJubhwtHdMQloMbnKTZUdJjuyXjJZuvoqXcXrErqjXzyzTqHFzBLhHfzFRYQh","NxHKYZEJUjefqyWVTZmhXvnHXJibhwtHdMQloMbnKTZodJjuyXjJZuvuqXcXrurqjXzyzTqHFzBLhHfzFRYQh");
		MAP.put("sJNoiczybMLCBfGhqvBQScEpfXpOXrXRwFkMLsMfbYqSbymRpJYdWuyhWJdZlYQNdmcByhQxXVkkpfQPgMLXXUh","sJNEOczybMLCBfGhqvBQScUpfXpiXrXRwFkMLsMfbYqSbymRpJYdWoyhWJdZlYQNdmcByhQxXVkkpfQPgMLXXuh");
		MAP.put("PDxPGKMmNQiRttHnWgznHskYRzXFZyDcEyxSHNqFgKmienjsuMLZVjDwudNZorZygYiyouFnNTJqJEmkQbPeLhhY","PDxPGKMmNQERttHnWgznHskYRzXFZyDcEyxSHNqFgKmeenjsiMLZVjDwidNZirZygYoyouFnNTJqJumkQbPuLhhY");
		MAP.put("PSCuLlpzHVPelNQFHepZsvTwBoOHdbFMUyTmYjljGVrmoHRJttCWBZnKyhXWmEKRwwYiIZQvchQBQgxsWYxFDKFvB","PSCELlpzHVPIlNQFHOpZsvTwBUeHdbFMeyTmYjljGVrmiHRJttCWBZnKyhXWmoKRwwYouZQvchQBQgxsWYxFDKFvB");
		MAP.put("jPJbOiIHYrHdNStYxEzrOkTWDqTEhsqdNVrYZCDepoZFVutbhcqfLMfonvPFHJDFeWbHFTOuluzfIxLYlvIoPnDuJ","jPJbEEIHYrHdNStYxIzrIkTWDqTOhsqdNVrYZCDOpOZFVetbhcqfLMfenvPFHJDFiWbHFToolozfuxLYlvuuPnDuJ");
		MAP.put("LQnwXgtmeniOUrZzFrRwvIwnTJrmzfVtOnCeEdcFrdGWlfTDEExnTwhjeoDzrpLERnCSpDKFvHICVYYRlNQfOoexy","LQnwXgtmEnEEErZzFrRwvIwnTJrmzfVtInCOOdcFrdGWlfTDOUxnTwhjeeDzrpLeRnCSpDKFvHeCVYYRlNQfiooxy");
		MAP.put("mTESPoKWoQhBdMuSUUECGmfWRXEugkbeojUFCCvXiRbkskDELQgbgHBiLkUyMGLMdJIDRjrHRTEYChJpUfOQdfCmR","mTESPEKWEQhBdMESEIOCGmfWRXUUgkbUUjUFCCvXeRbkskDiLQgbgHBiLkoyMGLMdJoDRjrHRToYChJpufuQdfCmR");
		MAP.put("DKeDPpznPTZDHHhNSfZqwFQgymXSBSrmSNBCIICVwbhIrfGnyHcwtOmispUrOEnPZKuRFTdxyffkglyCeNMYhYgmBi","DKEDPpznPTZDHHhNSfZqwFQgymXSBSrmSNBCIICVwbhIrfGnyHcwtOmOspUreenPZKiRFTdxyffkglyCiNMYhYgmBu");
		MAP.put("fhSrckkQSiXsvIgsNFssEfNimGRYvsjwUEwpmKKsdpHGjUFtPphWyzSherYZdMLIMYPeFnwWWlQKcwePzwyHfvWCEZq","fhSrckkQSEXsvEgsNFssEfNImGRYvsjwIUwpmKKsdpHGjUFtPphWyzSherYZdMLeMYPeFnwWWlQKcwiPzwyHfvWCiZq");
		MAP.put("BgYKXbdufwzgSdPLXtrDTScKtHIQZFfeffhXpKbJcPkZQkhymHhBJwoiXQmwlZZzIkEtDYvbkrgcePIrMCELCiPcmuZytTT","BgYKXbdEfwzgSdPLXtrDTScKtHEQZFfIffhXpKbJcPkZQkhymHhBJwIIXQmwlZZzeketDYvbkrgciPirMCoLCuPcmuZytTT");
		MAP.put("pzJclJFQVtqPIJKhlEHtcxXDcOYQVlOoJfZHlEKkougNmDCgiyeVPbkMHNqeuLRjOldxygtcvPrGiFmrZINVRywULmcnksjYgdfooNIyIv","pzJclJFQVtqPEJKhlEHtcxXDcIYQVlIIJfZHlIKkOOgNmDCgOyUVPbkMHNqeeLRjildxygtcvPrGiFmrZoNVRywoLmcnksjYgdfooNuyuv");
		MAP.put("cnldBOLUJnVepRzvEgUDOPuMoOiSmWssrCsUVjZnEjhrEExiRBsclSFXBTblsbLPNsJRgXefChGfbHWngqDfHdiWCuMBkjUYlqxNEKqgtuOKIDBlGBxhBWnhlPb","cnldBELEJnVEpRzvEgEDIPOMOOOSmWssrCsUVjZnUjhrUUxeRBsclSFXBTblsbLPNsJRgXefChGfbHWngqDfHdiWCiMBkjiYlqxNoKqgtuuKuDBlGBxhBWnhlPb");
		MAP.put("oJyIZMhUoYsrHVxvWSkeFqoGYePjGvIfjcGhGYteVNGWFCYUjoQplXwxbIWROPMGLMHIeBDMTByXQGtNWRpOCLdgEMJKSgeZThTHrgmmXeqybdTtVbsQZbUHMDwzdxks","EJyIZMhIIYsrHVxvWSkIFqOGYOPjGvUfjcGhGYtUVNGWFCYUjeQplXwxbeWRePMGLMHeeBDMTByXQGtNWRpeCLdgoMJKSgoZThTHrgmmXoqybdTtVbsQZboHMDwzdxks");
		MAP.put("cQMwmuTvLgwomydJGXEqmBUSLZVypgIJZEBEjMSTxnzMnsgxJKKbOTDysIdsXYlVVKSclzktjSJpEdJELCqNwdrWHmTjBCVhOZgQiPbBLflwsoUDrOIZhYshHfQVopZv","cQMwmETvLgwEmydJGXEqmBESLZVypgEJZIBIjMSTxnzMnsgxJKKbITDysOdsXYlVVKSclzktjSJpOdJOLCqNwdrWHmTjBCVhUZgQUPbBLflwsioDrooZhYshHfQVupZv");
		MAP.put("XQjMeMuQOPjPPnSYomRtFHKuDWPGWrdqTNecyvrDerNTsnmQENIWpxCldrFVlLSkJDjBRvgwknjSMoblosHjCZVhbgbIvEppCtsImlOFsCyeiiYKRLOmNrpmeFqquHegsZiqnZkcvqtJ","XQjMEMEQIPjPPnSYImRtFHKIDWPGWrdqTNOcyvrDOrNTsnmQONeWpxCldrFVlLSkJDjBRvgwknjSMeblesHjCZVhbgbeveppCtsemliFsCyiioYKRLomNrpmoFqquHugsZuqnZkcvqtJ");
		MAP.put("mmkngEntUjoJwOuJgLEwnmjTzVPGggldZMLsKpKPkpZLesksmdIoqMykOfEzlKCBSojkZXwYwiwUCcDUlDgcCflnGvdpZfENECPVqFbgHNZuIVvzkVOPndgsRjiJXdHiEMvEHIcKXqvwN","mmkngEntEjEJwEEJgLEwnmjTzVPGggldZMLsKpKPkpZLEsksmdIIqMykIfOzlKCBSOjkZXwYwOwUCcDUlDgcCflnGvdpZfUNeCPVqFbgHNZiiVvzkViPndgsRjoJXdHooMvuHucKXqvwN");
		MAP.put("xffEzKylIkYxIekgTNQwfZuYNXLKJZlVtQitsXuhMbbJbRicnToRqQUptcjuCNmoLRtNezBqjhZLwiKtBwIlKqEdwRDfOIviyuvhwbMeLmdfGsDKdKUtgVSTCVikDWGdtPRbRRLIntwmWrcfZCWzttLBmQ","xffEzKylEkYxIIkgTNQwfZIYNXLKJZlVtQItsXIhMbbJbROcnTURqQUptcjeCNmeLRtNezBqjhZLwiKtBwilKqidwRDfiivoyovhwbMuLmdfGsDKdKutgVSTCVukDWGdtPRbRRLuntwmWrcfZCWzttLBmQ");
		MAP.put("oysBBlobsfjKxbEOZxtKONbUlPeHkDDhXuLyrXcZPfDzzPCxrCBhVywhhTCKKkNGKPmSpyewQScFLrOPvFZihXQyIzzuFqtQoIpJPCvJuNVCjXWkLGxBqkZzeCkjbHUdmyYsXDXlxtvLFEeLoNNdrmSjjpFRbvTRsK","EysBBlEbsfjKxbIIZxtKONbOlPOHkDDhXULyrXcZPfDzzPCxrCBhVywhhTCKKkNGKPmSpyUwQScFLrePvFZehXQyezzeFqtQiopJPCvJoNVCjXWkLGxBqkZzoCkjbHodmyYsXDXlxtvLFuuLuNNdrmSjjpFRbvTRsK");
		MAP.put("hReFxXKpqoRFGUQwKxDlnmxbOBrxEgPvlhMBqsXCpbhHplSJjNOQPJyYPuiMRstOCFgePrNEbCxIeuxTOOvwpIiHTGLrMxKlWqbrunSfEjIHYlljGmQtofVhiRwgSHOyNrKkxjzkIsilkJUtcoorGyTSHkOUJKYBOLEiXNvtDzFHY","hREFxXKpqERFGEQwKxDlnmxbEBrxIgPvlhMBqsXCpbhHplSJjNIQPJyYPIIMRstOCFgOPrNObCxOOOxTOOvwpUUHTGLrMxKlWqbrUnSfejeHYlljGmQtefVhiRwgSHiyNrKkxjzkisilkJitcoorGyTSHkooJKYBuLuuXNvtDzFHY");
		MAP.put("RQDGYGfUBNOjFyiECUpiyqvbwZBKJwQQeoYyKCZcIlWUMFrEIvftpUDbsJMRXrxTNfFPqftPQrjFPSJWzTsisEQrFUFCpIEwWCyHsotHfmFGbyFfzdmkbigOcgWXvXbHTOCglYrPupFOOvbtcTndWbogURGeTcYYBPLFTkmuFiNxeNoIbFC","RQDGYGfEBNEjFyEECIpIyqvbwZBKJwQQIIYyKCZcOlWOMFrOOvftpODbsJMRXrxTNfFPqftPQrjFPSJWzTsUsUQrFUFCpUUwWCyHsUtHfmFGbyFfzdmkbegecgWXvXbHTeCglYrPipFiivbtcTndWbigiRGoTcYYBPLFTkmoFoNxoNuubFC");
		MAP.put("yfHhidUOLEunHGqFpigeMmkekOXfHxleyMGFcEvfwVJvKExUoWrbHYFWQtBSZgLwSzQbjOBEwTbJhRlGWkwPxjWdeSvejCgrlXEgWtVffuqGqJWvmWluGMXNtNlprrQhFpoUtKVSlYnVjKrvqFhKZvqkmjDzJdbULVxPNsbqvoMBImJpfhTEsJtKpNvEMGSwgbnzIRlVDufDZh","yfHhEdEELEEnHGqFpEgEMmkIkIXfHxlOyMGFcOvfwVJvKOxUUWrbHYFWQtBSZgLwSzQbjUBUwTbJhRlGWkwPxjWdeSvejCgrlXegWtVffeqGqJWvmWleGMXNtNlprrQhFpiitKVSlYnVjKrvqFhKZvqkmjDzJdboLVxPNsbqvoMBomJpfhTusJtKpNvuMGSwgbnzuRlVDufDZh");
		MAP.put("xzoMxnzcOCSsmgUvWzFtJyiWDHSpsGVEwCboxyZPTEKvDJyyliYuelwRoNsldWUYRKbstZhUnDrGzomvUksHsyzUmHFqYOoFFkwXdSNocBXWUxMXjeJdicpoIlOGBtrBPnpuFTCCVJVzIyiGngqUswsEdCNUwisvZPgiQMcwMyLQTJfWLnVVEySGYrOtcRysZvqbXkMJNPvgpbZdKVSGeeJQRFLwYNdhwsMwZzOxFG","xzEMxnzcECSsmgEvWzFtJyEWDHSpsGVIwCbIxyZPTOKvDJyylOYOOlwRONsldWUYRKbstZhUnDrGzUmvUksHsyzUmHFqYUUFFkwXdSNUcBXWexMXjeJdecpeiliGBtrBPnpiFTCCVJVziyiGngqiswsodCNowosvZPgoQMcwMyLQTJfWLnVVoySGYrotcRysZvqbXkMJNPvgpbZdKVSGouJQRFLwYNdhwsMwZzuxFG");
		MAP.put("wnWoFWwyEJyekCiwbpVoEgJTTGLZmwsmgLpFDJkEsDVcHfmjodVsrdbyKoFbMsyHNfwNSpHvVNJpBxtlPRrRgGrVMUTUdDEQRuzyVhHdFwLsrIgXCqNBIycMbIwTEdYskyBRvUcTWKSIuoeHnLXhQScqpeKMgTJSGmRpTKiRXtmDlfhifymLQFvLkQLrkBUlxYDyVSzpJSsIXDuUmJvqfmSCHsRpvODUBJdYrKKwZqlVy","wnWEFWwyEJyEkCEwbpVEIgJTTGLZmwsmgLpFDJkIsDVcHfmjIdVsrdbyKIFbMsyHNfwNSpHvVNJpBxtlPRrRgGrVMITOdDUQRUzyVhHdFwLsrUgXCqNBUycMbUwTUdYskyBRvecTWKSeeiiHnLXhQScqpiKMgTJSGmRpTKoRXtmDlfhofymLQFvLkQLrkBolxYDyVSzpJSsoXDoumJvqfmSCHsRpvuDuBJdYrKKwZqlVy");
		MAP.put("XtJwFHvkSXqdMqpIVYcNBDRmdDcndTEDMMDBTCycyBHeeRqqjdYcOgWteEfqjeDDHBQJSglsEHIyjSBONhwNilXeCksGhXLdWYGBnQwmnEinqIpkCTRvKBsYIFLSJkqfYgsjdIuYOxvQMGgDGbQMKLKPmGOqjYMfxOUslNBosZWkbkqupkmoFgefYmRXjcoFOiBfVQprPOPWvloQqGNNCpszVTXZxRQErQOsKiwZnHObpCzuepfPmOpxhxefTrxdNdlsTLgGzipCBEZbURqWybmnN","XtJwFHvkSXqdMqpEVYcNBDRmdDcndTEDMMDBTCycyBHEERqqjdYcEgWtEIfqjIDDHBQJSglsIHIyjSBINhwNOlXOCksGhXLdWYGBnQwmnOOnqOpkCTRvKBsYOFLSJkqfYgsjdOOYOxvQMGgDGbQMKLKPmGOqjYMfxUUslNBesZWkbkqepkmeFgefYmRXjceFeeBfVQprPePWvliQqGNNCpszVTXZxRQirQisKiwZnHibpCzoopfPmopxhxofTrxdNdlsTLgGzupCBuZbuRqWybmnN");
		MAP.put("bIFgEoPNFXklOveGLNublovPMWdxYQTkyJMMeNzejqdltjpyKWovRMjMyqxmJZywzmKdlrJPkSFbmkNceGMwNTGhkKrnSKDFEwvqNWQdBznDMPqrQvxBftMslZhQFqquTPTOVJbtDOcXGEVdqykJhOSHhCfYKOrQKonMfzZIPpGIeKNptryuMWdEKvuNDNlmgklEUUSLIWSiQCBuySkJGHmXbCnPbhmruMcwjeNNSitfShFOXFOPlyObrwTGVrBfoBIlbXvniWITzDTbLHPZFeuTmq","bEFgEEPNFXklEvEGLNIblIvPMWdxYQTkyJMMINzIjqdltjpyKWIvRMjMyqxmJZywzmKdlrJPkSFbmkNcIGMwNTGhkKrnSKDFOwvqNWQdBznDMPqrQvxBftMslZhQFqqOTPTOVJbtDOcXGOVdqykJhOSHhCfYKOrQKOnMfzZUPpGUeKNptryeMWdeKveNDNlmgkleeeSLiWSiQCBiySkJGHmXbCnPbhmroMcwjoNNSotfShFoXFoPlyubrwTGVrBfuBulbXvnuWuTzDTbLHPZFuuTmq");
		MAP.put("lTeGnkMsuuNBVTtTXJIfGJlPSBItZDKKtIykgnhDCVFNVwsrCXwGovxEsSsFMOGxQTNVvmGkRKFlifDpTIoksikdGhXJsqCivJIqqSYvfzQtxCZltQvKVTduzSfeIYkJwPnCzWDFPGYVvQQnkWjtMHlkxxiDerclfIUUHfmVUKVwgpmItyXSJRYxVBCWOSdXdZeQGlHwDmhitcqboOxcRbszRpHOnSWTPHEFGwXeBPUdNlyNXCESRNUnvsDyzyzOnsDOPLeQWxZfFfuPWjBxgcLOPwjNnxsO","lTEGnkMsEENBVTtTXJIfGJlPSBItZDKKtIykgnhDCVFNVwsrCXwGIvxIsSsFMIGxQTNVvmGkRKFlIfDpTIOksOkdGhXJsqCOvJOqqSYvfzQtxCZltQvKVTdOzSfOOYkJwPnCzWDFPGYVvQQnkWjtMHlkxxODUrclfUUUHfmVUKVwgpmetyXSJRYxVBCWeSdXdZeQGlHwDmhetcqbeexcRbszRpHinSWTPHiFGwXiBPidNlyNXCiSRNonvsDyzyzonsDoPLuQWxZfFfuPWjBxgcLuPwjNnxsu");
		MAP.put("vZogHBRYDeeyZtCMPrfHsutrsSwfYwwlgPsyDLhuSQEJGMySIbijxfxYFfkPkqRNHVdRqHQbBcNYXxrdzslgfCBGMrtWjLqbuwLQIySXyxslDsNlVtwRGWqvnweTuBCHMNCDTOKiKJmHjcuhZkTBdvCCqhwjcznrWfVkMLwTgfJYWZTpETTiOpBkSduVUqdeXORmJkEmBOuRwNChRyGmqDHhsljNuXKMdHmFVJhwEvvqMrVPzwYdvcsdLfLdRBfTxpzpTYrmtFzpJwkigGlEpDCZYLvVsbkSveSqoBKIlD","vZEgHBRYDEEyZtCMPrfHsEtrsSwfYwwlgPsyDLhESQIJGMySIbIjxfxYFfkPkqRNHVdRqHQbBcNYXxrdzslgfCBGMrtWjLqbOwLQOySXyxslDsNlVtwRGWqvnwOTOBCHMNCDTUKeKJmHjcehZkTBdvCCqhwjcznrWfVkMLwTgfJYWZTpeTTeepBkSdiViqdiXiRmJkomBouRwNChRyGmqDHhsljNuXKMdHmFVJhwuvvqMrVPzwYdvcsdLfLdRBfTxpzpTYrmtFzpJwkugGlupDCZYLvVsbkSvuSquBKulD");
		MAP.put("gsPzlfYSwVLWjWCYCiEnctokBycmbUZzxXndevQfWKUEJonyhpuSggWzgybSXeytBYNIlJVULgisxrQXKwXROzwNqCCBwrrvIDeLWznyncXSGkxgQhiwbCzoBJBIbGrvPfxrZguxOnzWrXEYScszjPRrOFYounzQGIzmLEONlfTrhgrUJNMwFYzmmGsoVBteMKJkPdrTTjIPzHFoFbfktZCeUDwULpWVhWuTceLOSzLMmjMMpbIhkiRCvSGqrESKSOnpikBePhZXFtbjGOEeIOJrmJHNrknQJWlPWsXFTSUDZgsRyqE","gsPzlfYSwVLWjWCYCEEnctEkBycmbEZzxXndEvQfWKEEJInyhpISggWzgybSXIytBYNIlJVILgIsxrQXKwXRIzwNqCCBwrrvODOLWznyncXSGkxgQhOwbCzOBJBObGrvPfxrZgOxOnzWrXOYScszjPRrUFYUUnzQGUzmLUUNlfTrhgrUJNMwFYzmmGseVBteMKJkPdrTTjePzHFeFbfktZCeeDweLpWVhWeTciLiSzLMmjMMpbihkiRCvSGqriSKSonpokBoPhZXFtbjGooouuJrmJHNrknQJWlPWsXFTSuDZgsRyqu");
		MAP.put("cFmmCUZhoijBFfhmMJuCQPzWKMkcObZwNkZlgKrsbmStQUJHsKiQQdsVVXLkIkbiybxPQucveWPKgFtnpJwEyKFumEpoUgUjvRppfsEvXogePSCpvDVbluzNzhvveihebboklPeHyZqzCoLjyeYvJGEupGigQXbBetcBvjZMBLRPbRuwPEDNjgEYxntECwBGrOhNDDyOPHTDZqXyHuTenQNXwMrWUVTXUXdXgjdhXHpFyTrTVoHVRbwGDLtKYziYDihRnFfKzqoBvXhFclkJCjMQZhHDQBTMpbpnZRTywpVxniMWIjgKUM","cFmmCEZhEEjBFfhmMJECQPzWKMkcEbZwNkZlgKrsbmStQEJHsKEQQdsVVXLkIkbIybxPQOcvOWPKgFtnpJwOyKFUmUpUUgUjvRppfsUvXUgePSCpvDVblezNzhvveehebbeklPeHyZqzCeLjyiYvJGiipGigQXbBitcBvjZMBLRPbRiwPiDNjgiYxntoCwBGrohNDDyoPHTDZqXyHoTonQNXwMrWoVTXoXdXgjdhXHpFyTrTVuHVRbwGDLtKYzuYDuhRnFfKzquBvXhFclkJCjMQZhHDQBTMpbpnZRTywpVxnuMWujgKuM");
		MAP.put("KtHyinrqLLtJdIjXhORpbObOHZCZdSUoXQzCeHNZLbKURBFVbThTLgYlNmMHcTDLKcjUIwoJNDBvPuGZOonZtkuZVJPxuGNUBycPGbBMJQKZxZIKQTnwwcWEYOOJBDSzoDgpviNFcrFGfcpjvjZtMqBxBDCPsgwxFlhFrqQKqPXSWfOSNtnTZzXgcPMzPMXqrlkMZfpfSeDlYFPYGSgBXbqMwMGSYOMQmgHuicDTqZFxfViXVwSEjMCbECzTBPGSIrFKqtxEyeRvsTrVUMLknVjxIZeqYrYNtyQYWIvBJuzvEXTnMZLXqbTkVnR","KtHyEnrqLLtJdEjXhERpbEbEHZCZdSIIXQzCIHNZLbKIRBFVbThTLgYlNmMHcTDLKcjIIwOJNDBvPOGZOOnZtkOZVJPxOGNOBycPGbBMJQKZxZOKQTnwwcWUYUUJBDSzUDgpvUNFcrFGfcpjvjZtMqBxBDCPsgwxFlhFrqQKqPXSWfeSNtnTZzXgcPMzPMXqrlkMZfpfSeDlYFPYGSgBXbqMwMGSYeMQmgHeicDTqZFxfViXVwSijMCbiCzTBPGSorFKqtxoyoRvsTrVoMLknVjxuZuqYrYNtyQYWuvBJuzvuXTnMZLXqbTkVnR");
		MAP.put("NXjnmeKkCRrmjpqneMWLtSWqBtzhvpUwNngVjEMJfmwinTmqqUHmFEkhklHNNunyYJFrlRiwigqTuxXGmBrKnINWIxYLtddzwUQnOMsZTwHvQMcbmORHnqBTzcBnyPjqFfLEOMlNyBrUlqWWtPWoOzlekPhZMWGFpdSdwRHPFkRCWwDRrMqPLTUpNlZgCoJtYykTiZtFNDbvYmGKBMDnLxoLdBiNLbwZJWUHHvXHsQNkoPygYoejuUIRkJuuRQiNWZnQYqEcyzGoHvikuyflcYfMQuFyLeTVhXdVHBMXHqwubPLkmVXLlRFYzPpnB","NXjnmEKkCRrmjpqnEMWLtSWqBtzhvpEwNngVjEMJfmwInTmqqIHmFIkhklHNNOnyYJFrlROwOgqTOxXGmBrKnUNWUxYLtddzwUQnUMsZTwHvQMcbmURHnqBTzcBnyPjqFfLUUMlNyBrelqWWtPWeezlekPhZMWGFpdSdwRHPFkRCWwDRrMqPLTepNlZgCiJtYykTiZtFNDbvYmGKBMDnLxiLdBiNLbwZJWiHHvXHsQNkiPygYiojoooRkJooRQuNWZnQYqucyzGuHvukuyflcYfMQuFyLuTVhXdVHBMXHqwubPLkmVXLlRFYzPpnB");
		MAP.put("XjINgbSEBBHZsJnSyBNGFehvHtNurdhzkdrzjOUgyPGoXVktusQZLSssSPtyrSicldDkmDJnxhYbWBTwfjXmQIxlYZeQJfgypsQsTSupNVxrLOhCukWuzsMKTiGJzXqhdrmslRtIpVmsrWXlmFzEpCLmZHiMxENRLVoOxNIHhIwZePkONuzjhUVQOzPrvSRHLDnsFeKzwxZzNPUjNiHTKCqGNNCnPKZquWcwXXipEeJShkSHtOMouUTwqlCDRqeQMCkyMQHbVgBomzSVgFGtbtKcQLDZOibfwSKBktdJGcMbePRNSRKqVUkbcHFDxit","XjENgbSEBBHZsJnSyBNGFEhvHtNErdhzkdrzjIIgyPGIXVktIsQZLSssSPtyrSIcldDkmDJnxhYbWBTwfjXmQOxlYZOQJfgypsQsTSOpNVxrLOhCOkWOzsMKTOGJzXqhdrmslRtUpVmsrWXlmFzUpCLmZHUMxUNRLVUexNeHhewZePkeNezjheVQizPrvSRHLDnsFiKzwxZzNPijNiHTKCqGNNCnPKZqiWcwXXipioJShkSHtoMoouTwqlCDRquQMCkyMQHbVgBumzSVgFGtbtKcQLDZuubfwSKBktdJGcMbuPRNSRKqVukbcHFDxut");
		MAP.put("twdTjKQLgMnRJFmOzTeJhGvJJNLRFsFEgjMfcbCgtiDKXTGBJzRkWShNKYMCjdwuzoiEFwzcJlvvccnVqMPGkTqGengrxEdcvtuSQzxhYjkzqptENRGlvmyqbhVPLVGtMvyunKlnrgFwTXWIKXUbVQVEiVrxBpyoxEVUmojvXdvyTYntXjmxbVWOytbYlXRXqYNoPLiuyXbGqqsgHkdqIpMMGBpFpwCYTdrNjeCdbdBkZmpDSEmkDnHHuqfOCkNtGNUHpJXHKJqvCzRmzsfvnOHcyTRjbLprVsGOSjZDhyPMccICQGrtqPUcooWObIBwwKkLKvWes","twdTjKQLgMnRJFmEzTEJhGvJJNLRFsFEgjMfcbCgtEDKXTGBJzRkWShNKYMCjdwEzEEIFwzcJlvvccnVqMPGkTqGIngrxIdcvtISQzxhYjkzqptONRGlvmyqbhVPLVGtMvyOnKlnrgFwTXWOKXObVQVOOVrxBpyUxUVUmUjvXdvyTYntXjmxbVWeytbYlXRXqYNePLeeyXbGqqsgHkdqipMMGBpFpwCYTdrNjiCdbdBkZmpDSimkDnHHiqfoCkNtGNoHpJXHKJqvCzRmzsfvnoHcyTRjbLprVsGoSjZDhyPMccoCQGrtqPocuuWubuBwwKkLKvWus");
		MAP.put("JBUFTkBOOyYzDzZzumqsyyswjiwEsXWEQrQZQeMzrCdtfBgttFutZzxkXpLkTefzRlYPpUrTqrKrbGYqHhVoyiPBVKMobLokHJbvoRCZIwCJcGbCfqXQNydycmylEhRjfwXIipJmZDGLmVcMvELlEEfvVbOCpRKxBnUjChmskVfyLBzEXYCxXVjzLNdJQjOOYdSciZEvzBKPRwZRPgwVzXurJcGsuvQGuvVTcImnGERVegLpuZyXnqunGYjcWsFkIhNvocSeWlMnpIDZVdrscBfEbFmgwtFIkFwcgZZRDorVVXDDormVrtGKslimPkbPXUOyUSWNvoiDUVKZXzsg","JBEFTkBEEyYzDzZzEmqsyyswjEwEsXWEQrQZQEMzrCdtfBgttFEtZzxkXpLkTEfzRlYPpIrTqrKrbGYqHhVIyIPBVKMIbLIkHJbvIRCZOwCJcGbCfqXQNydycmylOhRjfwXOOpJmZDGLmVcMvOLlOUfvVbUCpRKxBnUjChmskVfyLBzUXYCxXVjzLNdJQjUUYdSceZevzBKPRwZRPgwVzXerJcGsevQGivVTcimnGiRVigLpiZyXnqinGYjcWsFkohNvocSoWlMnpoDZVdrscBfobFmgwtFokFwcgZZRDorVVXDDormVrtGKslumPkbPXuuyuSWNvuuDuVKZXzsg");
		MAP.put("dhXfHxjecqlLeItfhIJtCTEbNfZXHZFphfMWhmEDhvRcTYdyklNWPgGFECiVkEgYxlXVTNdKoVoBihUclNVqVzScUfbBJDvlgQYgdIJSXJGMvosNkeFnLpCNTPxiLWKKuOXuwLZlbjshqYCFyigbTmeRqTVIxTQqeBGBtjruHmUgvuMDLcLbGKnwLQQwbQxcojcKUSStBxvivZrlmKcLHnmCtPRDNwhUGKBSXLOwRzGduNYQHEwHXkfxgGjevbDmoReSeLCNDPWsSCMndKCIJdlCdFPOjJSBcmcxKlTQcFnSYdrJjQxLWFkJCdQCyWELRqbHjvKxfEisbUieIgtdJuYFXPkuWotMpSUsRo","dhXfHxjEcqlLEEtfhEJtCTEbNfZXHZFphfMWhmEDhvRcTYdyklNWPgGFECIVkIgYxlXVTNdKIVIBIhIclNVqVzScOfbBJDvlgQYgdOJSXJGMvOsNkUFnLpCNTPxULWKKUUXUwLZlbjshqYCFyUgbTmURqTVexTQqeBGBtjreHmegveMDLcLbGKnwLQQwbQxcejcKeSStBxvevZrlmKcLHnmCtPRDNwheGKBSXLiwRzGdiNYQHiwHXkfxgGjivbDmiRiSiLCNDPWsSCMndKCoJdlCdFPojJSBcmcxKlTQcFnSYdrJjQxLWFkJCdQCyWoLRqbHjvKxfoosboouugtdJuYFXPkuWutMpSusRu");
		MAP.put("OIRSjHwJwUkNvuMhbZVPULysQokPhfPHFHgPjtFpKOrQYEGNoVfGrmPXwWhLjmpHUqptpPGIBRxLIspSfsYhCGWSWMKrorvNyxRoyMFmRZBWImxteTkMUCJNJyirqnXemLjkXCwwdzmHumemnkdkrhdTScCWpHjrxPMOONyNjenCBDUmDlHrUuZGzyeqWNXgQWXjubcleSPIQibXXCFZVUQROktXfUkjKKjoRNRcoOkycTlMtfeKYtbDRPreXKHMrZEbhDIvIBevVEldTUKNMMxooVEswRIQZKVZgNUrMYTSWbnZlqGIigZLEwCOoodyJuEnqBWbSLOiQTIiSrcZnIgRJDxVxTCnlwqqjwyKEsj","EERSjHwJwEkNvEMhbZVPELysQEkPhfPHFHgPjtFpKErQYIGNIVfGrmPXwWhLjmpHIqptpPGIBRxLIspSfsYhCGWSWMKrIrvNyxRIyMFmRZBWImxtITkMICJNJyIrqnXOmLjkXCwwdzmHOmOmnkdkrhdTScCWpHjrxPMOONyNjOnCBDOmDlHrOUZGzyUqWNXgQWXjUbclUSPUQUbXXCFZVUQRUktXfUkjKKjURNRceekycTlMtfeKYtbDRPreXKHMrZebhDeveBevVeldTiKNMMxiiViswRiQZKVZgNorMYTSWbnZlqGoogZLowCooodyJoonqBWbSLouQTuuSrcZnugRJDxVxTCnlwqqjwyKusj");
		MAP.put("hkfjsgStNhDFYbhcYNuoMNBPsLrTSrBYLRWsDRWjTYvXrgUHvXZcctbeyMotcmMqbIQwevLcUYvJZtmOtbQgDDmowzkDsrknhjPxYijKJNzCmNONEIHRVQExBvhGPbzRcLBdtuthVXoYJTffUtpiBbXqzKPNjnoJykTEkHjQXnoFOvJuTgOeHoPUHLDqLVSOSHFTfeFPlJKnIZMdqXDBjInVIrFMkGYzujDYsmHiRzIBigDSTwUFjKqbyoxDoOFmbMoBitKxoFsrhWVphCoIDrudLxQvNglQDFMIBjMHiYSYfiCkkEuTwuVoiTtNkJcqMvBKPtQYRXoiqhVcPxpWYRFRYxIXoplvJOnXKjGnKLJCJolCUBR","hkfjsgStNhDFYbhcYNEEMNBPsLrTSrBYLRWsDRWjTYvXrgEHvXZcctbEyMItcmMqbIQwIvLcIYvJZtmItbQgDDmIwzkDsrknhjPxYIjKJNzCmNINIOHRVQOxBvhGPbzRcLBdtOthVXOYJTffOtpOBbXqzKPNjnOJykTUkHjQXnUFUvJUTgUUHePeHLDqLVSeSHFTfeFPlJKniZMdqXDBjinVirFMkGYzijDYsmHiRziBigDSTwiFjKqbyixDooFmbMoBotKxoFsrhWVphCooDrodLxQvNglQDFMoBjMHoYSYfoCkkooTwoVooTtNkJcqMvBKPtQYRXuuqhVcPxpWYRFRYxuXuplvJunXKjGnKLJCJulCuBR");
		MAP.put("hYqFotuKbgCSrJwTHuVSfeVsJzxHBLyEGnrnPfbMFkOvocGUtbbIHitIQXMuKIlumLFbifItOZLiDKcBbxgYtWKyxuMpukTeYxdIgkDhGPTJGRZmymRVeSLMvLFFCpTGFeUzMOzFXcZCkJpziWXjUlZElDBbKMNhgmoNfNKRoWgydByhljGlBYQbFvpnmIHpFhpKITOvKimVKSyvvbTTDHVIFLFSiClOxpgyucSlGNccemCvHOiycVNIJRvRKkJiVvuRnBzsxnKtuDyIRtJCQBCvgZyOfWYQPkYufExKYXWUsZPRDBpqojrnbztHHSPfuMZSUYRfcgNTOGRzXGBwvGnxJmUWdfwXTUKTCbkZOMRvYqYxhBYHhxrqLZiTiKSSc","hYqFEtEKbgCSrJwTHEVSfIVsJzxHBLyIGnrnPfbMFkIvIcGItbbIHItIQXMIKIlOmLFbOfOtOZLODKcBbxgYtWKyxOMpOkTOYxdOgkDhGPTJGRZmymRVUSLMvLFFCpTGFUUzMUzFXcZCkJpzUWXjUlZUlDBbKMNhgmeNfNKReWgydByhljGlBYQbFvpnmeHpFhpKeTevKimVKSyvvbTTDHViFLFSiClixpgyicSlGNccimCvHiiycVNiJRvRKkJiVvoRnBzsxnKtoDyoRtJCQBCvgZyofWYQPkYofuxKYXWusZPRDBpqujrnbztHHSPfuMZSuYRfcgNTuGRzXGBwvGnxJmuWdfwXTuKTCbkZuMRvYqYxhBYHhxrqLZuTuKSSc");
		MAP.put("bzjHbkYlgeztTrhsBtfIwivoqPlYoeXBCmCiiLQzlCPjedwZOpTZxnRuWgtQjuqyhBtUeLfNJoouFWRZFzrIeJEtTBUrhIKrnNYexRgFzLNvbcSdgUrHjbKsDOpqZwMevmvGLvJXmUscrHZSFbDkirixpQtWRWBpNRmcIsCdrHBiWoCtRHeZGSzppDCFromYhlNsRumDwUlekwCCmHGHufTUclVkNfsgmRsPbuKnXWsSHzUoIOZRqoFJyLisjwjvxNqUmIzplQhDJFrvRvIqecKGWRGHorTjuixTGnwVFBPUyXSLXsmpGJdDErjNQpQwXCDpGkrgnhDqpOQkdYuiBypoixgyXNClitcOqditCjxzKfRMulVTfSyLJgVJQcVILnMOWqLXTgE","bzjHbkYlgEztTrhsBtfEwEvIqPlYIIXBCmCIILQzlCPjIdwZIpTZxnRIWgtQjOqyhBtOOLfNJOOOFWRZFzrUUJUtTBUrhUKrnNYUxRgFzLNvbcSdgUrHjbKsDUpqZwMUvmvGLvJXmescrHZSFbDkerexpQtWRWBpNRmcesCdrHBeWeCtRHeZGSzppDCFremYhlNsRemDwelikwCCmHGHifTiclVkNfsgmRsPbiKnXWsSHziiiiZRqiFJyLisjwjvxNqimizplQhDJFrvRvoqocKGWRGHorTjooxTGnwVFBPoyXSLXsmpGJdDorjNQpQwXCDpGkrgnhDqpoQkdYooBypuuxgyXNClutcuqdutCjxzKfRMulVTfSyLJgVJQcVuLnMuWqLXTgu");
		MAP.put("kqdCORrwudJtGIZgczybqlfvLemkdwBtDFfKjCuGJCEShCRYXpGhwmWInRDeHJrGsIYUJbfwvlhEKGXvzrSQQZjvIQKqyVeqUnczdegSfPJgjyPvBmRFXcqqsRrFrHJWifvSFLuQsxZIxQlWnsWbjYpJsGQLguzXHlOHESHWLqBPmcptcUPrrbRkwFRfEvJUxQznGUbZTUFHroPqmFsKMchXwwWXmdpkvvMrifggblmHCYBeYbXDCSirxbQjjZvFlptUHfMYLwpiNOnoMYwRCdmsKFRUCJWSmrVuLWoubyqmmMMPTVZgwLvKHYhquuSHQCsekswiQGmKSCqrxEzfxYzbKMLZFXGQPLoqVutJQiItGtjtzDrCTcXWpjNdQnjHeXFwntEfbXzuCMBSwhJSZ","kqdCERrwEdJtGEZgczybqlfvLEmkdwBtDFfKjCEGJCEShCRYXpGhwmWInRDIHJrGsIYIJbfwvlhIKGXvzrSQQZjvIQKqyVOqOnczdOgSfPJgjyPvBmRFXcqqsRrFrHJWUfvSFLUQsxZUxQlWnsWbjYpJsGQLgUzXHlUHUSHWLqBPmcptcUPrrbRkwFRfUvJexQznGebZTeFHrePqmFsKMchXwwWXmdpkvvMrefggblmHCYBeYbXDCSerxbQjjZvFlptiHfMYLwpiNiniMYwRCdmsKFRiCJWSmrViLWoobyqmmMMPTVZgwLvKHYhqooSHQCsukswuQGmKSCqrxuzfxYzbKMLZFXGQPLuqVutJQuutGtjtzDrCTcXWpjNdQnjHuXFwntufbXzuCMBSwhJSZ");
		MAP.put("qjghgjrhlDFxmMnNGrQqFscwWZDoKRIPddNwcScNWHwFycHwcxICZNnXlouVXbnzPMwcqhPsFZDhcbtgSrGPJjQYnuJTtzyCkXgnKDIIECNerNLiSgYOiewMfloWWhhkpzBVQfiDsMrRInlnjyYQotrZRRBtczJnwGhgbhWqExGHCDbVmFpiEOXrHcUqCiBOXjRjikoywdpyLLhPWwNJDrqIVLZDVMgROGxYCBYJiVXJTxrrxbMUrFBmtjGbpMKXlTceTBhyZtrPFHSjWkpDYNFYhsOyvgcGykKWEpPNhKRiMuTIQKUbUlOHQIjDcEcnvRbCkRtXNJWzrkLHlbeiqnieYmXzhHZVigQIUKHYsWIcPWptfxRYqonPfmEIFztCmFFujmvSVIPXFxObEMSzclgqgiPJJeRMl","qjghgjrhlDFxmMnNGrQqFscwWZDEKREPddNwcScNWHwFycHwcxECZNnXlEEVXbnzPMwcqhPsFZDhcbtgSrGPJjQYnEJTtzyCkXgnKDEIICNIrNLISgYIIIwMflIWWhhkpzBVQfIDsMrRInlnjyYQItrZRRBtczJnwGhgbhWqIxGHCDbVmFpOOOXrHcOqCOBOXjRjOkUywdpyLLhPWwNJDrqUVLZDVMgRUGxYCBYJUVXJTxrrxbMUrFBmtjGbpMKXlTceTBhyZtrPFHSjWkpDYNFYhseyvgcGykKWepPNhKReMeTeQKibiliHQijDcicnvRbCkRtXNJWzrkLHlbiiqniiYmXzhHZVigQiiKHYsWocPWptfxRYqonPfmooFztCmFFojmvSVoPXFxubuMSzclgqguPJJuRMl");
		MAP.put("JESnhmKcfMUQNFOinSbbMPOpoxEUzhMYUnMLzWLiOKTcofusollNkJMbJYgQkJjBdVHbPVhNTXpJtDePExoIZKnEiSWtBrfeEQMJuUQsNDVdTQgVXRbexszwXsgPZGogKxTPVLPCCgDuzYumHzHuUqLSYXmgQyUokmWOyeCsUvDkukYEYBwFsDgZGddbkbmrvijgwEnpQshISkflveEOIOrwVnuJPCUvDhJjlSBGNdpZMhvWgQtkIZkIFnRsvcyIbdBfhHlwlSOHqgSSDoMZSQfOokvxojKOXjjNhYciltvTGErIqDqqdktwqnNrCIikFIYCiIcmjRduPGfuGOLyDlSDenRUbPZmXsRgOJyRUTwuDdGGKskBvKxKsqkWHBFJbBbGMTchDTJnRpRqpvZFZDKrmBzMeCIyTbMoyzITDczqquSXcYPVFEFnKeRBIrgpqwGf","JESnhmKcfMEQNFEEnSbbMPEpExEEzhMYEnMLzWLEIKTcIfIsIllNkJMbJYgQkJjBdVHbPVhNTXpJtDIPIxIIZKnIISWtBrfIIQMJIOQsNDVdTQgVXRbOxszwXsgPZGOgKxTPVLPCCgDOzYOmHzHOOqLSYXmgQyOOkmWOyOCsUvDkUkYUYBwFsDgZGddbkbmrvUjgwUnpQshUSkflvUUUUerwVneJPCevDhJjlSBGNdpZMhvWgQtkeZkeFnRsvcyebdBfhHlwlSeHqgSSDeMZSQfiikvxijKiXjjNhYciltvTGiriqDqqdktwqnNrCookFoYCoocmjRdoPGfoGoLyDlSDonRobPZmXsRguJyRuTwuDdGGKskBvKxKsqkWHBFJbBbGMTchDTJnRpRqpvZFZDKrmBzMuCuyTbMuyzuTDczqquSXcYPVFuFnKuRBurgpqwGf");
		MAP.put("kgHSGyIbINvdRMYUStxGxEhoZYpKszIRlrvwYmqRwEZJsPfiMhQrJRrHQiHMLhhbFHvoUjiMpRIJLrUtssEtsYsOZvlnoUBRjjWfGUuswMkMWlkiIiXivwqUINkfPnEVnFFHieeoGFvBrNIMcJkZKLDzbekmsrPiJCoXzNDszYHrnSckYkGxFUEMHRVVbiZpjiUQCfkrWFfDhxMhNuQbxkElYobMvqhpvZBlVrLRnRdjnhyDXQscfkkHlcGDntHubzLeCtiGBVQtCCxLjqoeYJSYSNDqypIWZeyNojcITqYDgedVUyRjccmFtPOvqYQgqXnmFDshrNNKjgTzXZLiLBQusXOtmOceHCnuDBTNfWpMQSeBQLxQKGmdqUttovNnIkyTnowoGUifTKomqwpKYqQkjGiMsTqBMdCuHfOfuXzLVgyqsxNpTfbSfUpHDMEbkOlRtUcSj","kgHSGyEbENvdRMYEStxGxEhEZYpKszERlrvwYmqRwEZJsPfIMhQrJRrHQIHMLhhbFHvIIjIMpRIJLrItssItsYsIZvlnIOBRjjWfGOOswMkMWlkOOOXUvwqUUNkfPnUVnFFHUUUUGFvBrNUMcJkZKLDzbUkmsrPUJCUXzNDszYHrnSckYkGxFUeMHRVVbeZpjeeQCfkrWFfDhxMhNeQbxkelYebMvqhpvZBlVrLRnRdjnhyDXQscfkkHlcGDntHebzLeCtiGBVQtCCxLjqiiYJSYSNDqypiWZiyNijciTqYDgidViyRjccmFtPivqYQgqXnmFDshrNNKjgTzXZLiLBQisXitmicoHCnoDBTNfWpMQSoBQLxQKGmdqottovNnokyTnowoGoofTKomqwpKYqQkjGoMsTqBMdCuHfufuXzLVgyqsxNpTfbSfupHDMubkulRtucSj");
		MAP.put("qQkYQByhOErBEdkZyHlbyLSGdsKnVFRiYWNCyxPtsXkvwjOzunyzBDwxsGtqBByiEoxRZnEjpEenjFrvDcgBmctDXzSgDeKuxPKEBFkTjpKmgLDxWnouzJWYsUGLtxqBfWbMeobZLmwbbVdcgRUlJWpOlwJfkuIlLtiUdHosrQMRuFBZqljQcWZdXwoLYmvVHiPJbgSzWBxJgcQvxfOGDNUDtOXMxBIWKcFTVWXgKefnwvDksugfiLCeRpzcoDNGjfOTFLbkLwMrlqIqZdvsvfGcNuEhLbvBnMszRCuQSUDIfecvqXRtzcKBsnPlDZFXscmreOlJQzOPDnCUfqNEukPObrRHRjUxGQgsRgxDdxSyDRozduXLBZoCnTLYznmfNNCGrHhrODQJOhqZvHWtVyiyWKmCQMfrHhHDIMEcbBrIGdPrziGrbbcrlLRkzNFGzDtvIQGzVOXlWgDbcZJfOKExsShlE","qQkYQByhEErBEdkZyHlbyLSGdsKnVFREYWNCyxPtsXkvwjEzEnyzBDwxsGtqBByEEExRZnEjpEInjFrvDcgBmctDXzSgDIKIxPKIBFkTjpKmgLDxWnIIzJWYsIGLtxqBfWbMOObZLmwbbVdcgROlJWpOlwJfkOOlLtOOdHOsrQMROFBZqljQcWZdXwOLYmvVHOPJbgSzWBxJgcQvxfOGDNUDtUXMxBUWKcFTVWXgKUfnwvDksUgfULCURpzceDNGjfeTFLbkLwMrlqeqZdvsvfGcNeehLbvBnMszRCeQSeDificvqXRtzcKBsnPlDZFXscmriilJQziPDnCifqNiokPobrRHRjoxGQgsRgxDdxSyDRozdoXLBZoCnTLYznmfNNCGrHhroDQJohqZvHWtVyuyWKmCQMfrHhHDuMucbBruGdPrzuGrbbcrlLRkzNFGzDtvuQGzVuXlWgDbcZJfuKuxsShlu");
		MAP.put("IhMQEMjQgQnCgdytSwikQCBTUBcMCOQVSEmnJBzJmxMTtdvpFXebFlhPWwZfUIEyVeopdcyUCPPVkMbdLXZwdOQjdUIbcvgzrRFPogtNCPwoNnXPudeuNuXrPvOZidrGwfKTyPZWceRGRVJjJfZilvclovCuPmjCYMgZhclDorpZWURywxfzRLGgwDVssruXHzzyVuzcXGYSVCiHIxsRebiHfZowzfNJsXTnZKhIDfvZnTnOOwuSIkzXNZWBzsONrEZSflUFCetoJnhQvPvfofpXXFYVVXFPycdZhpnwneJNmIyjcoWtUJyPmYbuCFBwtgHoiGLkyUFXImUCGfKpuciBWbCpZGvUMrBIitxlzsuPrWIFPuiLvGflhGSunEwRprRjiqblcFShFJepwOgobYcpGpPgkToiQbgVGgBulyHWrMsyczIKUhoNfbhViNOmYSeoorNRmroVNxdrjxLzIrbqJNZzYHYHWNISk","EhMQEMjQgQnCgdytSwEkQCBTEBcMCEQVSImnJBzJmxMTtdvpFXIbFlhPWwZfIIIyVIIpdcyICPPVkMbdLXZwdIQjdIIbcvgzrRFPIgtNCPwINnXPOdOONOXrPvOZOdrGwfKTyPZWcORGRVJjJfZOlvclUvCUPmjCYMgZhclDUrpZWURywxfzRLGgwDVssrUXHzzyVUzcXGYSVCUHUxsRUbUHfZUwzfNJsXTnZKheDfvZnTneeweSekzXNZWBzseNreZSfleFCetiJnhQvPvfifpXXFYVVXFPycdZhpnwniJNmiyjciWtiJyPmYbiCFBwtgHiiGLkyiFXimiCGfKpocoBWbCpZGvoMrBootxlzsoPrWoFPooLvGflhGSonowRprRjoqblcFShFJopwogobYcpGpPgkTouQbgVGgBulyHWrMsyczuKuhuNfbhVuNumYSuuurNRmruVNxdrjxLzurbqJNZzYHYHWNuSk");
		MAP.put("fFJnrVlUpODYkgKXyjMeRtQGmFidfWZREJtbvOEJrtngVGscdmgPLubGUwqJvhzKSeHrzbQfwrcNsPQPoJMlCzJfPiBVPNjDQNhrsMKkZhrdCItLUdFMQWsjeREnxEcpmFMlYgXnTHYWLyoeZKnLZORScEVbQnfMgEPiZOTSsMOwQqnoSjtLckQIncOTgGoUnEkDxtXOUHtGXVwrgFfZMIZkKkzngjoLDFfSFfRxvOCuMgVdoTdtHqORnXkbvUjxSFRYUdmghwStFBqCOOZukOulwWcRpTUDFVQXbNJxcQzVOKJFVjEYWJjwWbYOrUFczDSwcOqYvDkOInechbfFilzeQGNJPgeXiNBoVwkHmqFlLvhpNVNcJKbOSqZTPXymRtkhiUezRLviMkkyTTUecDWCccMXHxbMBiHyQxEJhbiPBhcvZvjGhqgBvmdXdDEWFLKPgubPrkdPTfhhYGywxiBOIfDoyxcfGiMtZcPY","fFJnrVlEpEDYkgKXyjMERtQGmFEdfWZREJtbvEEJrtngVGscdmgPLEbGEwqJvhzKSEHrzbQfwrcNsPQPIJMlCzJfPIBVPNjDQNhrsMKkZhrdCItLIdFMQWsjIROnxOcpmFMlYgXnTHYWLyOOZKnLZORScOVbQnfMgOPOZOTSsMOwQqnOSjtLckQOncOTgGOOnOkDxtXOOHtGXVwrgFfZMUZkKkzngjULDFfSFfRxvUCUMgVdUTdtHqURnXkbvUjxSFRYUdmghwStFBqCUUZUkeelwWcRpTeDFVQXbNJxcQzVeKJFVjeYWJjwWbYereFczDSwceqYvDkeinichbfFilziQGNJPgiXiNBiVwkHmqFlLvhpNVNcJKbiSqZTPXymRtkhiiizRLvoMkkyTToocDWCccMXHxbMBoHyQxoJhboPBhcvZvjGhqgBvmdXdDoWFLKPgobPrkdPTfhhYGywxuBuufDuyxcfGuMtZcPY");
		MAP.put("klpYDccwMhyGUupBXLJguvmDOxqkItFdPnnFrRqEndCubkVToCDIOHgnqqZZGpbdfriBVYBoxUFPCTEjWKNvQtSyrcbxelypHsuHfYlPklSGmFCmOKDYbbbvXRrPquhqglqlbdzYmtRHheTXkHwPfVgTjJEnKrdMwxNkVVZOxOFWqvecxGjejSsvyDZGLpDeuBJosHbVyONHdZqbMpgwODsqnWqbSNeIXTfYETvcMtluXPOowBftLHKnXDruZTCMldeVBnbnkwZUlotwQJQkQlUwVLRwQENVmwvwJjixZnJpgLTlnnuitmdzZozYtRjgjJbxvuZLBdhcCgSdyYCYxpXPDFuPltCcqmzFYnWEdQZgxhLREMLKRqvvzVimKIuxQfkDUCmjZtmNpMNyubiPkriMjlcuYikBumkdkbmLtRUruNyTMKUXijBVIPmNpchwDztTcNVpGwfdGLOOrnswZvtXpEhSGiBjuevrhqPzC","klpYDccwMhyGEEpBXLJgEvmDExqkEtFdPnnFrRqEndCEbkVTECDIIHgnqqZZGpbdfrIBVYBIxIFPCTOjWKNvQtSyrcbxOlypHsOHfYlPklSGmFCmOKDYbbbvXRrPqOhqglqlbdzYmtRHhOTXkHwPfVgTjJOnKrdMwxNkVVZOxOFWqvOcxGjUjSsvyDZGLpDUUBJUsHbVyUNHdZqbMpgwUDsqnWqbSNUeXTfYeTvcMtleXPeewBftLHKnXDreZTCMldeVBnbnkwZelitwQJQkQliwVLRwQiNVmwvwJjixZnJpgLTlnniitmdzZizYtRjgjJbxviZLBdhcCgSdyYCYxpXPDFiPltCcqmzFYnWodQZgxhLRoMLKRqvvzVomKooxQfkDoCmjZtmNpMNyubuPkruMjlcuYukBumkdkbmLtRuruNyTMKuXujBVuPmNpchwDztTcNVpGwfdGLuurnswZvtXpuhSGuBjuuvrhqPzC");
		MAP.put("PENhDTJnyfxdgUXHlqvejkRqWPhQHsjSzfGIJrITjGyxPeJOiIRMdLDqdTmMZsnusdtJOqwpzoQwFtdmdCWJGleqWjPWFQzDoYIJNvBRDrLlIliSuZtlyvzrzheQRbejtvhPRpmyGUDyteiTYJJoHWyrvQqTZrlObLjiDGUHbfXxZNNIDHEmzIzgkHiguDvGLOzLeyjSxmZtqtiCXnkQiHNJSefwykCdBRtiYYwIGpzNrejFckYnFmOIQTJKEsgidPInkuXMysNpZTbIPnulHXJetmRHtKSwsLBKOtRogHjwOWiOEnidIwIVJxtLDJtwCfoqXcNDVBXKtdhUYyGIDWzpRQILDCTJxyeLjrrVyEwBrQGxYztFlTucDJDjkXtYUZfPMEsUfTMPQUImfgOMthYTxeKlwJfxuupXBEhUTnBjNGBPPnDOtHjcYNvGJLZGQtOXUzOhgmcBwYckMrDEpWlrGzwTIOkBYvQrYUgsz","PENhDTJnyfxdgEXHlqvEjkRqWPhQHsjSzfGEJrETjGyxPEJEEIRMdLDqdTmMZsnIsdtJIqwpzIQwFtdmdCWJGlIqWjPWFQzDIYIJNvBRDrLlIlISIZtlyvzrzhIQRbIjtvhPRpmyGIDytIITYJJIHWyrvQqTZrlIbLjODGOHbfXxZNNODHOmzOzgkHOgODvGLOzLOyjSxmZtqtOCXnkQOHNJSOfwykCdBRtOYYwUGpzNrUjFckYnFmUUQTJKUsgUdPUnkUXMysNpZTbUPnUlHXJetmRHtKSwsLBKetRegHjweWeeenedeweVJxtLDJtwCfeqXcNDVBXKtdheYyGiDWzpRQiLDCTJxyiLjrrVyiwBrQGxYztFlTicDJDjkXtYiZfPMisifTMPQiimfgiMthYTxoKlwJfxoopXBohoTnBjNGBPPnDutHjcYNvGJLZGQtuXuzuhgmcBwYckMrDupWlrGzwTuukBYvQrYugsz");
		MAP.put("ELzeXDSNNThHqsjFUzBsvNpbcYEENDcTxMsvqqtIWCBNxpOmCynyKHdVuMGPFLxgGdBCLSwDIcjFvjcbfdysOtiuJQrjOqFOhnoRWNxoGMpTFeKNmCZZiKkDIKuUCzrOUxprFOVDcztLzFtcnDBzlgiBxLtWtFnIZImFdjmjGRiOWJXprKeXHHwBiGzrtyHhtlREgMWKNyqevlqstNtrYPLEmzUBoDLOItzXLrlDSLIZxfFMcpZxnoMBoQunueMbCtQJToeeSJeOskFcjBBckeheyzstGlwNbZnMRreQCueTkBunXOtsvYZBLmjDTmlOZJeJWLVdeYTigerMSxlYpNysZMuREJsLxbBMReCCwedxDZMTxyIFFlSbmCKldBjGtQwHOtrRrwOXNKgPJhoNjpcxEgmnfnisMKfIWzYbZuRsWhilgLhNxpCzJqYgsOHjlQjHJFcHyISzqhrvlKhHrhjTbvwLXobkegtwmhjtet","ELzEXDSNNThHqsjFEzBsvNpbcYEENDcTxMsvqqtEWCBNxpEmCynyKHdVIMGPFLxgGdBCLSwDIcjFvjcbfdysItIIJQrjIqFIhnIRWNxIGMpTFIKNmCZZOKkDOKOOCzrOOxprFOVDcztLzFtcnDBzlgOBxLtWtFnOZOmFdjmjGROOWJXprKOXHHwBOGzrtyHhtlRUgMWKNyqUvlqstNtrYPLUmzUBeDLeetzXLrlDSLeZxfFMcpZxneMBeQeneeMbCtQJTeeeSJeeskFcjBBckeheyzstGlwNbZnMRreQCeeTkBinXitsvYZBLmjDTmliZJiJWLVdiYTigirMSxlYpNysZMiRoJsLxbBMRoCCwodxDZMTxyoFFlSbmCKldBjGtQwHotrRrwoXNKgPJhoNjpcxogmnfnusMKfuWzYbZuRsWhulgLhNxpCzJqYgsuHjlQjHJFcHyuSzqhrvlKhHrhjTbvwLXubkugtwmhjtut");
		MAP.put("VSpIQCdRMkiOelLxKIfizBNNZKGPDxUNBBLNEZxYLxQKeuiHTgiPRPpsqVwFpLHYfmYtzUEySyVyztUVylbxpHuUcgMxhdfbomfyvvMDCRzRWlzvvkxurKIQwsfjvLZxmviZhikeVVqklFpmPUNsddOgulVDBbIniOJXZsjGrnFUyCNpHKmEKptyxPsJwLldwkUoSoHrKhErjeeETEZvmlqJrxNpoPxZZdLpYDCQstEBIoGJSdMVWxZLpqMXphTdjtzSHTqwVwiJIOWjsMXWhlJkBoWfEFrqEVBfYsroRnlEUIoKrDhOmSotGKNmkdFuPSeCGQpyfuRqCKgZCQuHQnKMHZBLExIDrBphYlMIGorebvCCRhgXgPHtHfOOODeLUuhzwIqJrlTybLuisUjqbfNidKWJCOqkiPKHkyxPsxYTJvfQlGxCJnQZzgcyJoNbmhbLQUEHWgHbfeSPlBkXCXKeukuibRwPrsyNFViwxXZw","VSpEQCdRMkEEElLxKEfEzBNNZKGPDxENBBLNEZxYLxQKEEEHTgEPRPpsqVwFpLHYfmYtzIIySyVyztIVylbxpHIIcgMxhdfbImfyvvMDCRzRWlzvvkxIrKIQwsfjvLZxmvIZhIkOVVqklFpmPONsddOgOlVDBbOnOOJXZsjGrnFOyCNpHKmOKptyxPsJwLldwkUUSUHrKhUrjUUUTUZvmlqJrxNpUPxZZdLpYDCQstUBUeGJSdMVWxZLpqMXphTdjtzSHTqwVweJeeWjsMXWhlJkBeWfeFrqeVBfYsreRnleeiiKrDhimSitGKNmkdFiPSiCGQpyfiRqCKgZCQiHQnKMHZBLixiDrBphYlMiGiribvCCRhgXgPHtHfoooDoLoohzwoqJrlTybLoosojqbfNodKWJCuqkuPKHkyxPsxYTJvfQlGxCJnQZzgcyJuNbmhbLQuuHWgHbfuSPlBkXCXKuukuubRwPrsyNFVuwxXZw");
		MAP.put("rUImvzEkEjpVFNcMNsHszFOPHDYPtxNmmcWCffXhiEOQpgksbkyeXgmrXlXEutEpjmnFcZQMKlpfMCOGgMJyyHIHuRipwdmjUdblMIBrcqfEIClJgdyFyMHMTeJZfwOTXYzyxDFeXhGyiPshDNnXSlWkxYBcuNpUXbnuPcKerMuILUQtDUNseSwKHMkqruJhRqEYgvqdJBCwgSjMUibpgEQbWNsoEBrdNupqmZPCFGLuwSEkcntKRQyxbTQnHUIpwSQKuwTtXeKOqKDfudCVuuGCpgodCcXplwXtINWyhgMgGnPnGfncHbltuTlPoLBnmfWQMBNGuleFiKNVfgiLikpRROrKRqhQPxmWSWvgIzxYOXoJhCVhRocYhcQMPjhCYJGNgKhEITlKlgorqGrPMMFufqMcWePjVsnuCrEztNxwGnrjBqqqOlrlJEvgQjBcUWivfFgtiQRzNuRxWErZDXrGdvFbCUhjnhEXyhkuKkrjOoHuO","rEEmvzEkEjpVFNcMNsHszFEPHDYPtxNmmcWCffXhEEEQpgksbkyEXgmrXlXEEtEpjmnFcZQMKlpfMCEGgMJyyHEHERIpwdmjIdblMIBrcqfIIClJgdyFyMHMTIJZfwITXYzyxDFIXhGyIPshDNnXSlWkxYBcONpOXbnOPcKOrMOOLOQtDONsOSwKHMkqrOJhRqUYgvqdJBCwgSjMUUbpgUQbWNsUUBrdNUpqmZPCFGLUwSUkcntKRQyxbTQnHeepwSQKewTtXeKeqKDfedCVeeGCpgidCcXplwXtiNWyhgMgGnPnGfncHbltiTlPiLBnmfWQMBNGiliFiKNVfgiLikpRRorKRqhQPxmWSWvgozxYoXoJhCVhRocYhcQMPjhCYJGNgKhooTlKlgurqGrPMMFufqMcWuPjVsnuCruztNxwGnrjBqqqulrlJuvgQjBcuWuvfFgtuQRzNuRxWurZDXrGdvFbCuhjnhuXyhkuKkrjuuHuu");
	}

	@Test
	void testSortVowels()
	{
		String message = "";
		for (Map.Entry<String, String> entry : MAP.entrySet())
		{
			final String string = entry.getKey();
			final String expected = entry.getValue();
			final String actual = SortVowelsInAString.sortVowels(string);

			message = "Test failed on case: " + string
				+ ".\nExpected : " + expected
				+ "\nActual   : " + actual;

			assertEquals(expected, actual, message);
		}
	}

	@Test
	void testSortVowelsAlternativeSolution()
	{
		String message = "";
		for (Map.Entry<String, String> entry : MAP.entrySet())
		{
			final String string = entry.getKey();
			final String expected = entry.getValue();
			final String actual = SortVowelsInAString.sortVowelsAlternativeSolution(string);

			message = "Test failed on case: " + string
				+ ".\nExpected : " + expected
				+ "\nActual   : " + actual;

			assertEquals(expected, actual, message);
		}
	}
}