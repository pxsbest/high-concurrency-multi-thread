package org.pinery;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author ${USER}
 * @DateTime ${DATE} ${TIME}
 * @Description
 **/
public class Main {
    public static void main(String[] args) {
        String[] arr = search.split(",");
//        List<String> arr1 = List.of(arr);
//        Map<String, List<String>> collect = arr1.stream().collect(Collectors.groupingBy(s -> s));
//        collect.forEach((k,v)->{
//            if (v.size() > 1) {
//                System.out.printf("k:%s,v:%s",k,v.size());
//            }
//        });
    }

    private static String search="3,1,6,2,4,8,7,5,11,10,9,14,13,12,17,16,15,20,19,18,23,22,21,26,25,24,29,28,27,32,31,30,35,34,33,38,37,36,41,40,39,44,43,42,47,46,45,50,49,48,53,52,51,56,55,54,59,58,57,62,61,60,65,64,63,68,67,66,71,70,69,74,73,72,77,76,75,80,82,79,78,84,83,81,87,86,85,90,89,88,93,92,91,96,95,94,99,98,97,102,101,100,105,104,103,108,107,106,111,110,109,114,113,112,117,116,115,120,119,118,123,122,121,126,125,124,129,128,132,127,133,131,130,136,135,134,139,138,137,142,141,140,145,144,143,148,147,146,151,150,149,154,153,152,157,156,155,160,159,158,164,163,162,161,167,166,165,170,169,168,173,172,176,171,177,175,174,180,179,178,183,182,181,186,185,184,189,191,188,193,187,194,192,190,197,196,195,200,199,198,203,202,201,206,205,204,209,208,207,212,211,210,215,214,213,218,217,216,221,220,219,224,223,222,227,226,225,230,229,228,233,232,231,236,235,234,239,238,237,242,241,245,240,246,244,243,249,248,247,252,251,250,255,254,253,258,257,256,261,260,259,264,263,262,267,266,265,270,269,268,273,272,271,276,275,274,279,278,277,282,281,280,285,284,283,288,287,286,291,290,289,294,293,292,297,296,295,300,299,298,303,302,301,306,305,304,309,308,307,312,311,310,315,314,313,318,317,316,321,320,319,324,323,322,327,326,325,330,329,328,333,332,331,336,335,334,339,338,337,342,341,340,345,344,343,348,347,346,351,350,349,354,353,352,357,356,355,360,359,358,363,362,361,366,365,364,369,368,367,372,371,370,375,374,373,378,377,376,381,380,379,384,385,383,382,388,387,386,391,390,389,394,393,392,397,396,395,400,399,398,403,402,401,406,405,404,409,408,407,412,411,410,415,414,413,418,417,416,421,420,419,424,423,422,427,426,425,430,429,428,433,432,431,436,435,434,439,438,437,442,441,440,445,444,443,448,447,446,451,450,449,454,453,452,457,456,455,460,459,458,463,462,465,461,467,466,464,470,469,468,473,472,471,476,475,474,479,478,477,482,481,480,485,484,483,488,487,486,491,490,489,494,493,492,497,496,495,500,499,498,503,502,501,506,505,504,509,508,507,511,510,514,513,512,517,516,515,520,519,523,524,525,522,527,518,528,530,531,532,526,521,535,533,537,538,539,529,540,536,534,543,544,542,541,547,546,545,550,549,548,553,552,551,556,555,554,559,558,557,562,561,560,565,564,563,568,567,566,571,570,569,573,576,577,578,579,580,581,582,583,584,572,574,586,585,575,589,588,592,593,594,595,596,597,598,587,599,591,590,602,603,601,600,606,605,604,609,608,607,612,611,610,615,614,613,618,617,616,621,620,619,624,623,622,627,626,625,630,629,628,633,632,631,636,635,634,639,640,641,638,637,644,643,642,647,646,645,650,649,648,653,652,651,656,655,654,659,658,657,662,661,660,665,664,663,668,667,666,671,670,669,674,673,672,677,676,675,680,679,678,683,682,681,686,685,684,689,690,691,688,687,694,693,692,697,696,695,700,699,702,698,704,703,701,707,706,705,710,709,708,713,712,715,711,717,716,714,720,719,718,723,722,721,726,725,724,729,728,727,732,731,730,735,734,733,738,737,736,741,740,739,744,743,742,747,746,745,750,749,748,753,752,751,756,755,754,759,758,757,762,761,760,765,764,763,768,767,766,771,770,769,774,773,772,777,776,775,780,781,782,783,784,785,779,778,788,787,790,786,792,791,789,795,794,793,798,797,796,801,800,799,804,803,802,807,806,805,810,809,808,813,812,811,816,815,814,819,818,817,821,820,824,822,823,827,826,825,830,829,828,833,832,831,836,835,834,839,838,837,842,841,840,845,844,843,848,847,846,851,850,849,854,853,852,857,856,855,860,861,859,858,864,863,862,867,869,870,871,872,873,874,875,876,877,878,879,880,881,866,865,883,882,868,886,885,884,889,888,887,892,891,890,895,896,897,894,893,900,899,898,903,902,905,907,908,909,910,911,912,913,914,901,915,906,904,918,917,916,921,920,919,924,923,922,927,926,925,930,929,933,934,935,936,937,938,939,940,941,942,943,944,945,946,947,948,949,950,951,952,953,954,955,956,957,958,959,960,961,962,963,964,965,966,967,968,969,970,971,972,973,974,975,928,976,932,931,979,980,978,977,983,982,981,986,985,984,989,988,987,992,991,990,995,994,993,998,997,996,1001,1000,999,1004,1003,1006,1007,1009,1010,1011,1012,1013,1002,1014,1008,1005,1017,1016,1015,1020,1019,1018,1023,1022,1021,1026,1025,1024,1029,1028,1027,1032,1031,1030,1035,1034,1033,1038,1037,1036,1041,1040,1039,1044,1043,1042,1047,1046,1045,1050,1049,1048,1053,1052,1051,1056,1055,1054,1059,1058,1057,1062,1061,1060,1065,1067,1068,1069,1070,1064,1063,1072,1071,1066,1075,1074,1073,1078,1077,1076,1081,1080,1079,1084,1083,1082,1087,1086,1085,1090,1089,1088,1094,1095,1096,1097,1098,1099,1093,1092,1102,1103,1104,1105,1106,1107,1091,1109,1110,1111,1112,1113,1114,1115,1116,1117,1118,1119,1120,1121,1122,1123,1124,1125,1126,1127,1128,1129,1130,1131,1132,1133,1134,1135,1136,1137,1138,1139,1140,1141,1142,1108,1144,1145,1146,1147,1148,1149,1150,1151,1152,1153,1154,1155,1156,1157,1158,1159,1160,1161,1162,1163,1164,1165,1166,1167,1168,1169,1170,1171,1172,1173,1174,1175,1176,1177,1178,1179,1180,1181,1182,1183,1184,1185,1101,1100,1188,1189,1187,1186,1192,1193,1194,1143,1195,1197,1198,1199,1191,1190,1202,1203,1204,1201,1200,1207,1208,1209,1196,1210,1212,1213,1214,1206,1205,1217,1218,1219,1216,1215,1222,1223,1224,1225,1211,1226,1228,1229,1230,1221,1220,1233,1234,1235,1232,1231,1238,1239,1240,1227,1241,1243,1244,1245,1237,1236,1248,1249,1250,1247,1246,1253,1254,1255,1256,1257,1258,1242,1259,1261,1262,1263,1264,1252,1251,1267,1268,1269,1266,1265,1272,1273,1274,1275,1276,1277,1278,1279,1260,1280,1282,1283,1284,1285,1286,1287,1288,1289,1290,1291,1292,1293,1294,1295,1296,1297,1298,1299,1300,1301,1302,1303,1304,1305,1306,1307,1308,1309,1310,1311,1312,1313,1314,1315,1316,1317,1318,1319,1320,1321,1322,1323,1324,1325,1326,1327,1328,1329,1330,1331,1332,1333,1334,1335,1336,1337,1338,1339,1340,1341,1342,1343,1344,1345,1346,1347,1348,1349,1350,1351,1352,1353,1354,1355,1356,1357,1358,1359,1360,1361,1362,1363,1364,1365,1366,1367,1368,1369,1370,1371,1372,1373,1374,1375,1376,1377,1378,1379,1380,1381,1382,1383,1384,1385,1386,1387,1388,1389,1390,1391,1392,1393,1394,1395,1396,1397,1398,1399,1271,1270,1401,1400,1404,1405,1406,1407,1408,1409,1410,1411,1412,1413,1414,1415,1416,1417,1418,1419,1420,1421,1422,1423,1424,1425,1426,1427,1428,1429,1430,1431,1432,1433,1434,1435,1436,1437,1438,1439,1440,1441,1442,1443,1444,1445,1446,1447,1448,1449,1450,1451,1452,1453,1454,1455,1456,1457,1458,1459,1460,1461,1462,1463,1281,1464,1403,1402,1467,1466,1465,1471,1472,1473,1474,1475,1476,1477,1478,1479,1480,1481,1482,1483,1484,1485,1486,1487,1488,1489,1490,1491,1492,1493,1494,1495,1496,1497,1498,1499,1500,1501,1502,1503,1504,1505,1506,1507,1508,1509,1510,1511,1512,1513,1514,1515,1516,1517,1518,1519,1520,1521,1522,1523,1524,1525,1526,1527,1528,1529,1530,1531,1532,1533,1534,1535,1470,1469,1468,1538,1540,1541,1542,1543,1544,1545,1537,1536,1548,1549,1547,1546,1552,1553,1539,1554,1556,1557,1551,1550,1560,1561,1559,1558,1564,1565,1566,1567,1555,1568,1570,1571,1563,1562,1573,1575,1576,1577,1578,1579,1580,1581,1582,1583,1584,1585,1586,1587,1588,1589,1572,1569,1591,1590,1574,1595,1596,1597,1598,1599,1600,1601,1602,1594,1604,1605,1606,1607,1608,1609,1593,1592,1612,1613,1614,1615,1611,1610,1618,1619,1620,1621,1622,1623,1624,1625,1626,1627,1628,1629,1630,1631,1632,1633,1634,1635,1636,1637,1603,1638,1617,1616,1641,1643,1644,1645,1646,1647,1648,1649,1650,1651,1652,1653,1654,1655,1656,1657,1658,1659,1640,1639,1661,1663,1664,1665,1666,1667,1668,1669,1670,1671,1672,1673,1674,1675,1676,1677,1678,1679,1680,1681,1682,1683,1684,1685,1686,1687,1688,1689,1690,1691,1692,1693,1694,1695,1696,1697,1698,1699,1660,1642,1701,1703,1704,1705,1700,1662,1708,1709,1707,1706,1712,1713,1702,1714,1716,1717,1718,1719,1720,1721,1722,1723,1724,1725,1726,1727,1728,1729,1730,1731,1732,1733,1734,1735,1736,1737,1711,1710,1740,1741,1742,1739,1738,1745,1746,1747,1715,1748,1750,1751,1752,1753,1754,1755,1756,1757,1744,1759,1760,1761,1762,1763,1743,1764,1766,1767,1768,1769,1770,1771,1772,1773,1774,1775,1776,1777,1778,1779,1780,1781,1782,1783,1784,1785,1786,1787,1788,1789,1790,1791,1758,1749,1793,1795,1796,1797,1798,1799,1800,1801,1802,1803,1804,1805,1806,1807,1808,1809,1810,1811,1812,1813,1814,1815,1816,1817,1818,1819,1820,1821,1822,1823,1824,1825,1826,1827,1828,1829,1830,1831,1832,1833,1792,1765,1836,1837,1835,1834,1840,1841,1842,1843,1844,1845,1846,1847,1848,1794,1849,1839,1852,1853,1854,1838,1855,1857,1858,1851,1850,1861,1862,1860,1859,1865,1866,1867,1868,1869,1856,1870,1872,1873,1864,1863,1876,1877,1875,1874,1880,1881,1871,1882,1884,1885,1886,1879,1878,1889,1890,1891,1888,1887,1894,1895,1883,1896,1898,1899,1893,1892,1902,1903,1901,1900,1906,1907,1897,1908,1910,1911,1905,1904,1914,1915,1913,1912,1918,1919,1920,1921,1922,1909,1923,1925,1926,1917,1916,1929,1930,1931,1932,1928,1927,1935,1936,1924,1937,1939,1940,1934,1933,1943,1944,1942,1941,1947,1948,1949,1938,1950,1952,1953,1946,1945,1955,1956,1958,1959,1960,1961,1962,1963,1964,1965,1966,1967,1968,1969,1970,1971,1972,1973,1974,1975,1976,1977,1978,1979,1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020,2021,2022,2023,2024,2025,2026,2027,2028,2029,2030,2031,2032,2033,2034,2035,2036,2037,2038,2039,2040,2041,2042,2043,2044,2045,2046,2047,2048,2049,2050,2051,1954,1951,2054,2055,2056,2057,2058,2059,2060,2061,2062,2063,2064,2065,2066,2067,2068,2069,2070,2071,2072,2073,2053,2052,2076,1957,2077,2078,2079,2081,2082,2083,2075,2074,2085,2084,2088,2089,2090,2091,2092,2093,2094,2080,2095,2097,2098,2099,2100,2101,2102,2103,2104,2105,2106,2107,2108,2109,2110,2111,2112,2113,2114,2115,2116,2117,2118,2119,2120,2121,2122,2123,2087,2086,2125,2124,2096,2128,2130,2131,2132,2133,2134,2135,2136,2137,2138,2139,2140,2141,2142,2143,2144,2145,2146,2147,2148,2149,2150,2151,2152,2153,2154,2155,2156,2157,2158,2159,2160,2161,2162,2163,2164,2165,2166,2167,2168,2169,2170,2171,2172,2173,2174,2175,2176,2177,2178,2179,2180,2181,2182,2183,2184,2185,2186,2187,2188,2127,2126,2190,2189,2193,2194,2195,2196,2197,2198,2199,2200,2201,2202,2129,2203,2205,2206,2192,2191,2209,2210,2208,2207,2213,2214,2204,2215,2217,2218,2219,2220,2212,2211,2223,2224,2225,2222,2221,2228,2229,2216,2230,2232,2233,2227,2235,2236,2237,2238,2239,2240,2241,2242,2243,2244,2245,2246,2247,2248,2249,2250,2251,2252,2253,2254,2255,2256,2257,2258,2259,2260,2261,2262,2263,2264,2265,2266,2267,2268,2269,2270,2271,2272,2273,2226,2274,2234,2231,2277,2279,2280,2281,2282,2283,2284,2285,2276,2287,2288,2289,2275,2290,2292,2293,2294,2295,2296,2286,2278,2299,2300,2301,2302,2303,2304,2305,2306,2298,2297,2309,2310,2311,2291,2312,2314,2315,2316,2317,2318,2319,2308,2307,2322,2323,2324,2325,2321,2320,2328,2329,2330,2331,2313,2333,2334,2335,2336,2337,2332,2327,2340,2341,2342,2326,2343,2345,2346,2347,2348,2349,2339,2338,2352,2353,2354,2355,2356,2357,2358,2351,2350,2361,2362,2363,2344,2364,2366,2367,2368,2360,2359,2371,2372,2373,2374,2370,2369,2377,2378,2379,2365,2380,2382,2383,2384,2376,2375,2387,2388,2389,2390,2391,2392,2393,2394,2395,2396,2397,2398,2399,2400,2401,2402,2403,2404,2405,2406,2407,2408,2409,2410,2411,2412,2413,2414,2415,2416,2417,2418,2419,2420,2421,2422,2423,2424,2425,2426,2427,2428,2429,2430,2431,2432,2433,2434,2435,2436,2437,2438,2439,2440,2441,2442,2443,2444,2445,2446,2447,2448,2449,2450,2451,2452,2453,2454,2455,2456,2457,2458,2459,2460,2461,2462,2463,2464,2465,2466,2467,2468,2469,2470,2471,2472,2473,2474,2475,2476,2477,2478,2479,2480,2481,2482,2483,2484,2485,2486,2487,2488,2489,2490,2491,2492,2493,2494,2495,2496,2497,2498,2499,2500,2501,2502,2503,2504,2505,2506,2507,2508,2509,2510,2511,2512,2513,2514,2515,2516,2517,2518,2519,2520,2521,2522,2523,2524,2525,2526,2527,2528,2529,2530,2531,2532,2533,2534,2535,2536,2537,2386,2385,2381,2541,2542,2543,2544,2545,2540,2539,2548,2549,2550,2551,2552,2553,2554,2555,2556,2557,2558,2559,2538,2560,2547,2563,2564,2565,2566,2567,2568,2569,2570,2571,2572,2573,2574,2575,2576,2577,2578,2579,2580,2581,2582,2583,2584,2585,2586,2587,2588,2589,2590,2591,2592,2593,2546,2594,2562,2561,2598,2599,2600,2601,2602,2603,2604,2605,2606,2607,2608,2609,2610,2611,2612,2613,2614,2615,2616,2617,2618,2619,2597,2621,2596,2595,2623,2625,2626,2627,2628,2629,2630,2631,2622,2633,2634,2635,2636,2637,2638,2639,2640,2641,2642,2643,2644,2645,2646,2647,2648,2649,2650,2651,2652,2653,2654,2655,2656,2657,2658,2659,2660,2661,2662,2663,2664,2665,2666,2667,2668,2669,2670,2671,2672,2673,2674,2675,2676,2677,2678,2679,2680,2681,2682,2683,2684,2685,2686,2687,2688,2689,2690,2691,2692,2693,2694,2695,2696,2697,2698,2699,2620,2701,2702,2703,2704,2705,2706,2707,2708,2709,2710,2711,2712,2713,2714,2715,2716,2717,2718,2719,2720,2721,2700,2722,2723,2725,2632,2624,2728,2729,2730,2727,2732,2733,2734,2735,2736,2737,2738,2739,2740,2741,2742,2743,2744,2745,2726,2747,2748,2749,2750,2751,2752,2753,2754,2755,2756,2757,2758,2759,2760,2761,2762,2763,2764,2765,2766,2767,2768,2769,2770,2771,2772,2773,2774,2775,2776,2777,2778,2779,2780,2781,2782,2783,2784,2724,2785,2786,2746,2789,2790,2791,2792,2793,2794,2795,2796,2797,2798,2799,2800,2801,2802,2803,2804,2805,2806,2807,2808,2809,2810,2811,2812,2813,2814,2815,2816,2817,2818,2819,2820,2821,2822,2823,2824,2825,2826,2827,2828,2829,2830,2831,2832,2833,2834,2835,2731,2837,2838,2836,2788,2841,2842,2843,2844,2845,2846,2787,2848,2849,2850,2851,2852,2853,2854,2855,2856,2857,2858,2859,2860,2861,2862,2863,2864,2865,2866,2867,2868,2869,2870,2871,2872,2873,2874,2875,2876,2877,2878,2879,2880,2881,2882,2883,2884,2885,2886,2887,2888,2889,2890,2891,2892,2893,2847,2840,2896,2897,2898,2899,2900,2901,2902,2903,2839,2904,2906,2907,2895,2894,2910,2911,2909,2908,2914,2915,2905,2916,2918,2919,2913,2912,2922,2923,2921,2920,2926,2927,2928,2929,2917,2930,2932,2933,2934,2935,2925,2924,2938,2939,2940,2941,2937,2936,2944,2945,2931,2946,2948,2949,2950,2951,2952,2943,2942,2955,2956,2957,2958,2959,2960,2961,2962,2963,2964,2965,2954,2967,2953,2947,2970,2971,2972,2973,2969,2968,2976,2977,2978,2979,2980,2981,2982,2983,2984,2985,2986,2987,2988,2989,2990,2991,2992,2993,2994,2995,2996,2966,2997,2975,2998,2974,3001,3003,3004,3005,3006,3007,3008,3009,3010,3011,3012,3013,3014,3015,3016,3017,3018,3019,3020,3021,3022,3023,3024,3025,3026,3027,3028,3029,3030,3031,3032,3033,3034,3035,3036,3037,3038,3039,3040,3041,3042,3043,3044,3045,3046,3047,3048,3049,3050,3051,3052,3053,3054,3055,3056,3057,3058,3059,3060,3061,3062,3063,3064,3065,3000,3067,2999,3068,3070,3071,3066,3002,3074,3075,3073,3076,3078,3079,3080,3081,3082,3083,3084,3085,3086,3087,3088,3089,3090,3091,3092,3072,3094,3095,3096,3097,3098,3099,3100,3101,3102,3103,3104,3105,3106,3107,3108,3109,3110,3069,3111,3093,3114,3115,3116,3077,3117,3117,3113,3120,3121,3122,3123,3112,3125,3126,3127,3128,3129,3130,3131,3132,3133,3134,3135,3136,3137,3138,3139,3124,3119,3142,3118,3143,3145,3146,3147,3148,3149,3150,3151,3152,3153,3154,3155,3156,3157,3158,3159,3160,3161,3162,3163,3164,3165,3166,3167,3168,3169,3170,3171,3141,3140,3173,3172,3176,3144,3178,3179,3180,3181,3182,3183,3177,3175,3186,3187,3188,3189,3190,3174,3191,3185,3194,3195,3196,3197,3198,3199,3184,3200,3202,3203,3204,3205,3206,3207,3208,3209,3210,3211,3212,3213,3214,3215,3216,3217,3218,3219,3193,3221,3222,3223,3224,3225,3226,3227,3192,3229,3230,3231,3232,3228,3234,3220,3236,3237,3238,3201,3240,3241,3242,3243,3244,3245,3246,3247,3248,3249,3250,3251,3252,3253,3254,3255,3256,3257,3258,3259,3260,3261,3262,3263,3264,3265,3266,3267,3268,3269,3270,3271,3272,3273,3274,3275,3276,3277,3278,3279,3280,3281,3239,3235,3233,3284,3283,3286,3288,3289,3290,3282,3292,3293,3294,3295,3291,3287,3298,3299,3285,3300,3302,3303,3304,3305,3306,3297,3296,3309,3310,3311,3312,3313,3314,3315,3316,3317,3318,3308,3307,3321,3322,3323,3324,3325,3326,3327,3328,3329,3330,3331,3332,3333,3301,3335,3336,3337,3338,3339,3340,3341,3342,3343,3344,3345,3346,3347,3348,3349,3350,3351,3352,3353,3354,3355,3356,3357,3358,3359,3360,3361,3362,3363,3364,3365,3366,3367,3368,3369,3334,3371,3372,3320,3374,3375,3376,3377,3319,3378,3380,3381,3382,3383,3384,3385,3386,3373,3370,3388,3390,3391,3392,3393,3394,3395,3396,3397,3398,3399,3400,3401,3402,3403,3404,3405,3406,3407,3408,3387,3379,3410,3409,3413,3414,3415,3416,3417,3389,3418,3420,3412,3422,3423,3424,3425,3426,3427,3428,3429,3430,3431,3432,3433,3434,3435,3436,3437,3438,3439,3440,3441,3442,3443,3444,3445,3446,3447,3448,3449,3450,3451,3411,3452,3421,3455,3456,3457,3458,3459,3460,3461,3462,3463,3464,3465,3466,3467,3468,3469,3470,3471,3472,3419,3473,3475,3476,3477,3478,3479,3480,3481,3482,3483,3484,3485,3486,3454,3453,3489,3490,3491,3492,3493,3494,3495,3496,3497,3498,3499,3500,3501,3502,3503,3504,3505,3506,3507,3508,3488,3487,3511,3512,3513,3514,3515,3516,3517,3518,3519,3520,3474,3522,3523,3524,3525,3521,3527,3528,3529,3530,3531,3532,3510,3509,3535,3536,3537,3538,3534,3540,3541,3533,3543,3544,3545,3546,3547,3548,3549,3550,3551,3552,3553,3554,3555,3556,3557,3558,3559,3560,3561,3562,3563,3564,3565,3566,3567,3568,3569,3570,3571,3572,3573,3574,3575,3576,3577,3578,3526,3579,3542,3582,3539,3583,3585,3586,3587,3588,3589,3590,3591,3592,3593,3594,3595,3596,3597,3598,3599,3600,3601,3602,3603,3604,3605,3606,3607,3608,3609,3610,3611,3612,3613,3614,3615,3616,3617,3618,3619,3620,3621,3622,3623,3624,3625,3626,3627,3628,3629,3630,3631,3632,3633,3634,3635,3636,3637,3638,3639,3640,3641,3642,3643,3644,3645,3646,3647,3648,3649,3650,3651,3652,3653,3654,3655,3656,3657,3658,3659,3660,3661,3662,3663,3664,3665,3666,3667,3668,3669,3670,3671,3672,3673,3674,3675,3676,3677,3678,3679,3680,3681,3682,3683,3684,3685,3686,3687,3688,3689,3690,3691,3692,3693,3694,3695,3696,3697,3698,3699,3700,3701,3702,3703,3704,3705,3706,3707,3708,3709,3710,3711,3712,3713,3714,3715,3716,3717,3718,3719,3720,3721,3722,3723,3724,3725,3726,3727,3728,3729,3730,3731,3732,3733,3734,3735,3736,3737,3738,3739,3740,3741,3581,3580,3744,3745,3746,3747,3748,3749,3743,3742,3752,3753,3754,3755,3584,3756,3758,3759,3760,3761,3751,3750,3764,3765,3766,3767,3768,3769,3770,3771,3772,3773,3774,3775,3776,3777,3778,3779,3780,3781,3782,3783,3784,3785,3786,3787,3788,3789,3790,3791,3792,3793,3794,3795,3796,3797,3798,3799,3800,3801,3802,3803,3804,3763,3762,3807,3808,3809,3810,3811,3812,3813,3814,3815,3816,3817,3818,3819,3820,3821,3822,3823,3824,3825,3826,3827,3828,3829,3830,3831,3832,3833,3834,3757,3835,3806,3805,3838,3837,3841,3842,3843,3844,3845,3846,3847,3848,3849,3850,3851,3852,3853,3854,3855,3856,3857,3858,3859,3860,3861,3862,3863,3864,3865,3866,3867,3868,3869,3870,3871,3872,3873,3874,3875,3876,3877,3878,3879,3880,3881,3882,3883,3884,3885,3886,3887,3888,3889,3890,3891,3892,3893,3894,3895,3896,3897,3898,3899,3900,3901,3902,3903,3904,3905,3906,3907,3908,3909,3910,3911,3912,3913,3914,3915,3916,3917,3918,3919,3920,3921,3922,3923,3924,3925,3926,3927,3928,3929,3930,3931,3932,3933,3934,3935,3936,3937,3938,3939,3940,3941,3942,3943,3944,3945,3946,3947,3948,3949,3950,3951,3952,3953,3954,3836,3955,3957,3840,3959,3960,3961,3962,3963,3964,3965,3966,3967,3968,3969,3970,3971,3972,3973,3974,3975,3839,3976,3978,3979,3980,3981,3982,3983,3984,3985,3986,3987,3988,3989,3990,3991,3992,3958,3994,3995,3956,3996,3998,3999,4000,4001,4002,4003,4004,4005,4006,4007,4008,4009,4010,4011,4012,4013,4014,4015,4016,4017,4018,4019,4020,4021,4022,4023,4024,4025,4026,4027,4028,4029,4030,4031,4032,4033,4034,4035,4036,3993,3977,4038,4040,4041,4042,4043,4044,4045,4037,4047,4048,4049,4050,4051,4052,4053,4054,4055,4056,4057,4058,4059,4060,4061,4062,4063,4064,4065,4066,4067,4068,4069,4070,4071,4072,4073,4074,4075,4076,4077,4078,4079,4080,4081,4082,4083,4084,4085,4086,4087,4088,3997,4090,4091,4092,4093,4094,4095,4096,4089,4097,4046,4039,4100,4102,4103,4104,4105,4106,4107,4108,4109,4110,4111,4112,4113,4114,4115,4099,4098,4118,4119,4120,4121,4122,4123,4124,4125,4126,4127,4128,4129,4130,4131,4132,4133,4134,4135,4136,4137,4138,4139,4140,4141,4117,4142,4143,4145,4146,4147,4116,4101,4149,4148,4151,4152,4154,4155,4156,4157,4158,4159,4144,4161,4162,4163,4164,4165,4160,4167,4168,4169,4170,4171,4172,4173,4174,4175,4176,4177,4178,4179,4180,4181,4182,4183,4153,4150,4186,4187,4185,4184,4190,4191,4192,4193,4194,4195,4166,4197,4198,4199,4200,4201,4202,4196,4204,4205,4206,4207,4208,4209,4210,4189,4212,4213,4214,4215,4216,4217,4218,4188,4219,4221,4222,4211,4203,4225,4226,4227,4224,4223,4230,4231,4232,4233,4220,4234,4236,4237,4229,4228,4240,4241,4242,4239,4238,4245,4246,4235,4247,4249,4250,4251,4252,4253,4254,4244,4243,4257,4258,4256,4255,4261,4262,4248,4263,4265,4266,4260,4259,4269,4270,4271,4268,4267,4274,4275,4264,4276,4278,4279,4280,4281,4282,4283,4273,4272,4286,4287,4285,4284,4290,4291,4277,4292,4294,4295,4289,4288,4298,4299,4300,4297,4296,4303,4304,4293,4305,4307,4308,4302,4301,4311,4312,4310,4309,4315,4316,4317,4318,4319,4320,4321,4322,4323,4324,4325,4326,4327,4328,4329,4330,4331,4332,4333,4334,4335,4336,4337,4306,4339,4340,4341,4342,4338,4314,4313,4345,4344,4343,4347,4346,4351,4350,4348,4354,4355,4356,4357,4358,4349,4359,4361,4362,4363,4364,4365,4366,4367,4368,4369,4370,4371,4372,4373,4374,4375,4376,4377,4378,4379,4380,4381,4382,4383,4384,4385,4386,4387,4388,4389,4390,4391,4392,4393,4394,4395,4396,4397,4398,4399,4400,4401,4402,4403,4404,4405,4406,4407,4408,4409,4410,4411,4412,4413,4414,4415,4416,4417,4418,4419,4420,4421,4422,4423,4424,4353,4426,4427,4428,4429,4430,4431,4352,4432,4434,4435,4436,4437,4438,4439,4440,4441,4442,4443,4425,4360,4446,4447,4448,4449,4450,4451,4452,4453,4454,4455,4456,4457,4458,4459,4460,4461,4462,4463,4464,4465,4466,4467,4468,4469,4470,4471,4472,4473,4474,4475,4476,4477,4478,4479,4480,4481,4482,4483,4484,4485,4486,4487,4488,4489,4490,4491,4492,4493,4494,4495,4496,4497,4498,4499,4500,4501,4502,4503,4504,4505,4506,4507,4508,4509,4510,4511,4512,4513,4514,4445,4444,4517,4433,4518,4520,4516,4522,4523,4524,4525,4526,4527,4515,4528,4530,4531,4532,4533,4534,4535,4521,4537,4538,4539,4540,4541,4542,4543,4544,4545,4546,4547,4548,4549,4550,4551,4552,4553,4554,4555,4556,4557,4558,4559,4560,4561,4562,4563,4564,4565,4566,4567,4568,4569,4570,4571,4572,4573,4574,4575,4576,4577,4578,4579,4580,4581,4582,4583,4519,4584,4586,4587,4588,4589,4590,4591,4592,4536,4529,4594,4596,4597,4598,4599,4600,4601,4602,4593,4604,4605,4606,4585,4607,4609,4610,4611,4603,4613,4614,4615,4616,4617,4618,4619,4620,4621,4622,4623,4624,4625,4626,4627,4628,4629,4630,4631,4632,4633,4634,4635,4636,4637,4638,4639,4640,4641,4642,4643,4644,4645,4646,4647,4648,4649,4650,4651,4652,4653,4654,4655,4656,4595,4657,4659,4660,4661,4662,4663,4664,4665,4666,4667,4668,4669,4670,4671,4672,4673,4674,4675,4676,4677,4678,4679,4680,4681,4682,4612,4608,4685,4686,4684,4688,4689,4690,4691,4692,4693,4694,4695,4696,4697,4698,4699,4700,4701,4702,4703,4704,4705,4706,4707,4708,4709,4710,4711,4712,4713,4714,4715,4716,4717,4718,4719,4720,4721,4722,4723,4724,4725,4726,4727,4728,4729,4730,4731,4732,4733,4734,4735,4736,4737,4738,4739,4740,4741,4742,4743,4744,4745,4746,4747,4748,4749,4750,4751,4752,4753,4754,4755,4756,4757,4758,4759,4760,4761,4762,4763,4764,4765,4766,4767,4768,4769,4770,4771,4772,4773,4774,4775,4776,4777,4778,4779,4780,4781,4782,4783,4784,4683,4658,4787,4788,4789,4790,4791,4792,4793,4794,4795,4796,4797,4798,4799,4800,4801,4786,4785,4804,4805,4806,4807,4808,4809,4810,4811,4812,4813,4814,4815,4816,4817,4818,4819,4820,4821,4687,4822,4824,4825,4826,4827,4803,4829,4830,4831,4832,4833,4834,4835,4836,4837,4838,4839,4840,4841,4842,4843,4844,4845,4846,4847,4848,4849,4850,4851,4852,4853,4854,4855,4856,4857,4858,4859,4860,4861,4862,4863,4802,4865,4866,4864,4868,4869,4870,4871,4872,4828,4823,4874,4875,4877,4878,4879,4880,4881,4873,4867,4884,4885,4886,4883,4888,4889,4890,4891,4892,4893,4894,4895,4896,4897,4898,4899,4900,4901,4902,4903,4904,4905,4906,4907,4908,4909,4910,4911,4912,4913,4914,4915,4916,4917,4918,4919,4882,4876,4922,4923,4924,4925,4926,4927,4928,4929,4930,4931,4921,4933,4934,4935,4936,4920,4938,4887,4940,4941,4942,4943,4944,4945,4946,4947,4948,4949,4950,4951,4952,4953,4954,4955,4956,4957,4958,4959,4960,4961,4962,4963,4964,4965,4966,4967,4968,4969,4970,4971,4972,4973,4974,4975,4976,4977,4978,4979,4980,4981,4982,4983,4984,4985,4986,4987,4988,4989,4990,4991,4992,4993,4994,4995,4996,4997,4998,4999,5000,4939,4937,4932";


}