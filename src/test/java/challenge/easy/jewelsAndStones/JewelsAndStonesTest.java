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
package challenge.easy.jewelsAndStones;

import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class JewelsAndStonesTest
{
	private static final Triple<String, String, Integer>[] TRIPLE = new Triple[]
		{
			new ImmutableTriple<>("IxwBf", "JAK", 0),
			new ImmutableTriple<>("zNaIXPdIq", "W", 0),
			new ImmutableTriple<>("YWcctIKVh", "ySP", 0),
			new ImmutableTriple<>("ULlWiByfmer", "rY", 1),
			new ImmutableTriple<>("z", "UspVFkaRODlX", 0),
			new ImmutableTriple<>("SJdtz", "YniKkPqzQ", 1),
			new ImmutableTriple<>("r", "ktWIbHQOXoFlTV", 0),
			new ImmutableTriple<>("sbHCuB", "dVncISjOm", 0),
			new ImmutableTriple<>("Z", "VyiQhFXWjIZuvYa", 1),
			new ImmutableTriple<>("EbV", "JFSpwRCqHbdcEnY", 2),
			new ImmutableTriple<>("uqwjG", "XxWKhBbLRQmusa", 1),
			new ImmutableTriple<>("ydjmnngdRAoGvG", "bKFBs", 0),
			new ImmutableTriple<>("TbEIShly", "TzSkEfneDCB", 3),
			new ImmutableTriple<>("EJiTcMviZMsTMlyD", "Xlcz", 2),
			new ImmutableTriple<>("VP", "NatZKFDYVROECskmjcL", 1),
			new ImmutableTriple<>("LrKoJR", "jWoIVcirKOtvzNXuM", 3),
			new ImmutableTriple<>("iilgQJODoej", "gjATMPiKlBkG", 4),
			new ImmutableTriple<>("NhyyAPaOUPVZNofQiCQODW", "aA", 2),
			new ImmutableTriple<>("sm", "jIEgLZMdJtYqRrkTWyOHfUw", 0),
			new ImmutableTriple<>("pZfemlMXvKkNCi", "LqtPZSTsgbKI", 2),
			new ImmutableTriple<>("SHcbpsibupXokVGqRyKMhvW", "mas", 1),
			new ImmutableTriple<>("nFmvKcUgzJoLxoWwzoyxX", "fQFmKh", 3),
			new ImmutableTriple<>("KyBugm", "QzmLpZawKbCdioqjtvcEN", 2),
			new ImmutableTriple<>("giOoeB", "zsBfvlbudioVmCtDZNESw", 3),
			new ImmutableTriple<>("tBXMcFhfgSHyBQfpvQoT", "cqwvAHSU", 4),
			new ImmutableTriple<>("H", "flmDcKrHJQszjiCgNWbtvpVZeyTRa", 1),
			new ImmutableTriple<>("eRToQFIg", "TVEHoIWAykjKfDFUGidxtLc", 4),
			new ImmutableTriple<>("WBGCnvNhaKiPSkVSAjJRlwgVJEik", "Xayc", 1),
			new ImmutableTriple<>("DeZYoXxOmCffTELmbm", "WlJkphXLPOMetc", 4),
			new ImmutableTriple<>("bGxbAiLVJ", "OTLAzmQrXSuKwWGJfaPibUo", 6),
			new ImmutableTriple<>("QhxJhocJbjdUZHeZ", "MonabcjYAeQJyZwpi", 8),
			new ImmutableTriple<>("ExaBOfxFRZwzpaz", "AZiIDRLdNxFlXofOjq", 6),
			new ImmutableTriple<>("tZFdLDCDBOYLKYsOuSzOj", "hrYIegyaVLwJB", 3),
			new ImmutableTriple<>("CcAWEyKcnYPIKGJGd", "XIaqGFjycZAWkBuPbO", 7),
			new ImmutableTriple<>("YotSxHMm", "eChyojTiEDxgMvOVzYfnAmrZFGH", 6),
			new ImmutableTriple<>("XSfoMnMs", "vesyBlPAwjgazqIhdJMutTXGRUb", 3),
			new ImmutableTriple<>("wyYsAxGxyLKvIDEoHRNOkOFGGVNTYqgwZn", "uY", 1),
			new ImmutableTriple<>("tymSLjrSfnSy", "NzVjdlRqHbKecmxOUiQXGZnY", 3),
			new ImmutableTriple<>("djGVWMjVzcziKMQyecxAg", "itmYPqXTHUbFJRrW", 2),
			new ImmutableTriple<>("aoHXrRKJRrGoPfrKygMDb", "PRbLBDxamTpGFgsy", 8),
			new ImmutableTriple<>("GOwiDRRkeWOUoAkGxAZufMxSexBWhmGoomngxD", "Y", 0),
			new ImmutableTriple<>("dOpGwdBLc", "XRqwOJDNMkvZzSTsAycEVBQiartbUj", 4),
			new ImmutableTriple<>("joKnnpBZungreWnGZypsCPo", "OUebAlyKLmCFMYfxw", 4),
			new ImmutableTriple<>("IVgJuRVyA", "JzQmaSoitPuNdvMfWHRwUjyDlGTgxCq", 5),
			new ImmutableTriple<>("KfDPmlrbGluKJtKGFBQTlcFWR", "AzpSTKgFrjGxIJUy", 6),
			new ImmutableTriple<>("avgdaJCPXZNtKn", "egNPOfWLoqBphdcXaDHUATuktjir", 7),
			new ImmutableTriple<>("yURDASIvRQjwaDnaQgxinRfTLBEGMyvLnXHzypzSF", "eK", 0),
			new ImmutableTriple<>("GpnPSspGhcmlduzTCPLVgRFYzo", "aYQkfgIUJHECDxKhvF", 5),
			new ImmutableTriple<>("VqAkeNFBDIPOXl", "yYhqSaDfWQBGNuHAKgslUxecFwbZmo", 8),
			new ImmutableTriple<>("gmxESqMQogtTlkfIM", "XHPJZuhpUFmtwfeTLMqVEBIKSg", 10),
			new ImmutableTriple<>("PuiStILYNRFTrZJCe", "FozqBeHgiupUsZCfbAwQPxScJVk", 9),
			new ImmutableTriple<>("tjtOvjOdrkcOUjyqK", "cseCGzXPqHhjWUuJQYkpDxFydAEN", 7),
			new ImmutableTriple<>("EfcEoBMApQlypkgkmZcvklcyLxJaEXRi", "KTNhMAsJnuboD", 4),
			new ImmutableTriple<>("ojOocVukNuionXXpVnhfiDPPFaIvw", "lnGejJDNmTzyiYFh", 7),
			new ImmutableTriple<>("AYFPkDUZzTXsgYDkEMEFITIcKXoFDCcZ", "YDEQBGgMhaqjmN", 5),
			new ImmutableTriple<>("nVsSjNqVtGdGHaMamCfzHcoEEzgoGnjZCS", "HQMOChisPaLYr", 5),
			new ImmutableTriple<>("bcrYTCvoJDtmhRlCcExmSARWmElgAnZKfkDeCUjIJ", "UqEVCN", 3),
			new ImmutableTriple<>("QBBMPhjYeChhUhudQdLrwIoauCU", "OAbDMsgjvBpHSTEuLwPF", 7),
			new ImmutableTriple<>("YuPIOgIJprvBwdigA", "QAxftudNcGIOqnkVzhEPibHWejYlBF", 9),
			new ImmutableTriple<>("hdMRHbChTslpDi", "lHNuULvXZKzxGtskhjaVndTSeiYoIcyCbgBm", 9),
			new ImmutableTriple<>("GjmxncvnclmvdhjwzvbnyyUCmaplqoOkHSHV", "SxHZMYAyPhJdsn", 7),
			new ImmutableTriple<>("iAZRIYYEuhxRVoeFQLxkZUpPiRoZXzaYunjKu", "EoNwRmyxudBDsif", 6),
			new ImmutableTriple<>("rdghPGWrrWAYElqhCPKm", "TzWbHAmBLNRkoVSuJDYXOaqUpKEPhgsr", 11),
			new ImmutableTriple<>("NYZNfBZAKRBQsXNkPiZxSQarxst", "SkjFhOrfXDoguJMBRZmiWsYvG", 11),
			new ImmutableTriple<>("HYrFNbqactbQxKaTPGnOgoQcdVJF", "NrSFMyhvbzcgPEIZXQdCaBqmT", 12),
			new ImmutableTriple<>("btRHKmYCSOEozgfCULySUJAxBBIjDd", "qKDmNoHhOMQzyatcdbAEiVkp", 13),
			new ImmutableTriple<>("VbYOZzaDdQalDpwvUbmHxsXNlFe", "aCcVdvpFAYumRxIPZgOHSUnMiDG", 14),
			new ImmutableTriple<>("XYfHwDWuIasVvJIWdiSJVaPenQvrgkclZQrHkkGuXqmBsV", "NsioSnZEp", 5),
			new ImmutableTriple<>("DybSOnFSXTGkvDssVMwnhzJodZpslwH", "yzvpNeORZYSUQfLbJBMjEknm", 12),
			new ImmutableTriple<>("GSUkWblaxhMbFBiSDRiYMHFA", "povOqYuFJxSUIzRVhZXlfBdTmLysDWa", 12),
			new ImmutableTriple<>("BVaZHlMsVjAALooCMQWaoWYESNlWbvDRxWFfHdrnnMaRyzd", "HcploDyPVm", 6),
			new ImmutableTriple<>("yGlbcIgxbSkJszjbpIQStpdHg", "gdBDnurGaeoFOAyxmUkHMCIWLVSijzl", 12),
			new ImmutableTriple<>("uDyNGQkMPkKEzgAyFCEcKTsAgRuEADsQNlbxliLFeyZaSophB", "hOpAyPbLs", 8),
			new ImmutableTriple<>("jOgQGpbNqwXvBJmiTIWoEQcKLbVnTpQoWglXfn", "XpaOnorzUMgHexZkqAFJ", 8),
			new ImmutableTriple<>("ucqrscDrjgbgUOdbRVgCepAlFoaosqp", "XCDvHEbItuaySqjiNlehdKVznkPB", 11),
			new ImmutableTriple<>("DqdSiRwCgHZvtmZxEgmCUGudkvxriHDuBpUSUOpA", "zrgvEbeRsAMcUNqunlPa", 9),
			new ImmutableTriple<>("kpYVNKrtStiNXIBiuaAylcHTZZqpNzlE", "YgWVaMsAmJNRoQfEBpqIdxThunv", 12),
			new ImmutableTriple<>("hXFJgNxLmSSICmzrkeWZAhmUiVIcEOJFZnYgAefB", "OkrIVsMZuNBPvRotwJnfH", 11),
			new ImmutableTriple<>("ofbwKmHYtKOLxEDGVpcocBOzTamaPIEDcX", "YSWTBasrUcbAJCeFvpZitoNxGwPR", 13),
			new ImmutableTriple<>("hPBGfPukTyvKcvOxPiZeLbbzFmaKIGdVbwXmLlLRenytQq", "LrIVkShpHjJaNGoEd", 8),
			new ImmutableTriple<>("ayFUEuZKgAhrCRdkMYblfBoNjluADnRFA", "bESxIYPqkHBGmngZXQeRpfuJLiANy", 14),
			new ImmutableTriple<>("bRFRrjMXLBMrvhjYiIMBcONHXtBjyJcBSUsmMAoCZSR", "WxEyZilUvbRdtzIgPAGf", 10),
			new ImmutableTriple<>("RrrbqObdIrMQSxgWYUBJINzVtXOiIhXgtTOKvbviSnS", "PYlIvGOsbztXJDVnEQMe", 13),
			new ImmutableTriple<>("MfZOsqLARjqUBHIIhWYCbKMCUfiKwGCigkHzIOgjn", "BdjnbhgwARaKsJTEHGuxPVe", 13),
			new ImmutableTriple<>("bvxzapSGSYOufVXDdmjEddyHHLtFCaySBWHMrjm", "hvgNARKTmkeWQHfxusLFCyzMSt", 15),
			new ImmutableTriple<>("FmRUwemKEdrRpYMJFgMMaXcSrRLokwNN", "FCebzqiVTJlXvHYcAyhrEfIjNxsBKRZLk", 13),
			new ImmutableTriple<>("npoCyuoawEOOihQiQNZIhYwKUzWggvaJIeyRjWChi", "nkyMtijXTprhUlGusJdKgfCP", 12),
			new ImmutableTriple<>("OuZOncgLtZnghUMgPWWkjISBtWeMTRjYuXyQSRjwWWuFnaPwww", "qNpPcjDXxIlZzoOg", 8),
			new ImmutableTriple<>("pCXbBwQhahoipHfGRvKrdRjNRSCBFStqktdarZGSOB", "qcSpKViegZNjBJxnETRoCdy", 13),
			new ImmutableTriple<>("sGCtDSdHAKrxQXjDnyXxxCxMzeldYoNqL", "RtESsbqVOkBnrPHXKpuGaNiwYcJoxfUvLhIy", 16),
			new ImmutableTriple<>("WqhuWqSuNyzlPwKzmJSqEsxqkPRvPwbNlpsqmESmrob", "JudOhoXWSIQRCiDVkZvNzTHbnYgr", 13),
			new ImmutableTriple<>("cGLppmSeeQGvRBSjjapbrUjxQTrUIqjuBKoQtzQpbXGt", "YpAJHFOGurjLzRBmsekVTUXqwdyE", 15),
			new ImmutableTriple<>("NwYsCiDrbjNPUugNYBCnMnEMMvnodNRUOhgOiyGmArxnn", "mzqknuTHcjZSfAopBEtVbyGUYPvX", 15),
			new ImmutableTriple<>("POZKJczPXxFWGIOQMiZswXUjUSzNpIWKTCAhZsbBk", "HMuvoVfeNilzcJRYCEXhrFULQkGqxOsd", 17),
			new ImmutableTriple<>("jUCpsCoPYatOmkLDFkTfZFexsJYXmZUZixIjyzKiDkJLH", "JdaFgetPOlAqxfLcGNCkVibUImsj", 18),
			new ImmutableTriple<>("dbzFzaiMoEXQCjzUqavDHUkQwjomPPALuUpvGWsugB", "qeowxKuAcVQdkEZFtvyBlrGCIDbTfPN", 17),
			new ImmutableTriple<>("PyWVoheXTFAQqxUKgofpuEtKOIiHWZDgThALpJhdAZrZyJno", "YMkqdEAxDelLRZVajvfPWFNnQB", 16),
			new ImmutableTriple<>("pXstJimXEfUzMMsVDmbGlBuyUkrFgGEdtNjzuyIjSkviYIvEX", "ozqrnhadWeJXKBtIYTNLGOMUZ", 13),
			new ImmutableTriple<>("EKJoFvPSLChYEOhXNeIWdgjiTbRZpmuNqlrHEQwmCorblxMdE", "haeNMUrGgbDYVzWcdyjFTLsmpBAuv", 18),
			new ImmutableTriple<>("skIOgkrROhIKetAbHLgFxcpBqUPfLeeczIrYqYGfOYaSLGqu", "SPjHTUJWmxEgIOsRcnliFkutYZGAhBp", 21),
		};

	@Test
	void numJewelsInStones()
	{
		for (Triple<String, String, Integer> t : TRIPLE)
		{
			final String stones = t.getLeft();
			final String jewels = t.getMiddle();
			final int expected = t.getRight();
			final int actual = JewelsAndStones.numJewelsInStones(stones, jewels);


			String message = "Test failed on case: " + stones + ":" + jewels
				+ ".\nExpected : " + expected
				+ "\nActual   : " + actual;

			assertEquals(expected, actual, message);
		}
	}
}