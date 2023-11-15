<!DOCTYPE html>
<html>
<head>
    <title>Sports Stars</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid black;
            background-color:grey;
        }

        th, td {
            padding: 8px;
            text-align: left;
            font-weight: bold;
            font-size:20px
        }

        th {
            background-color: pink;
        }

        ul {
            list-style-type: square;
        }
    </style>
</head>
<body >
    <h1>Anime World</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Sport</th>
            <th>Team</th>
            <th>Country</th>
        </tr>
        <?php
            // Load the XML file
            $xml = simplexml_load_file('anime.xml');

            // Check if the XML file was successfully loaded
            if ($xml) {
                // Loop through each athlete and display their information
                foreach ($xml->anime as $anime) {
                    echo "<tr>";
                    echo "<td>" . $anime->name . "</td>";
                    echo "<td>" . $anime->genre . "</td>";
                    echo "<td>" . $anime->IMDb . "</td>";
                    echo "<td>" . $anime->language . "</td>";
                    echo "</tr>";
                }
            } else {
                echo "<tr><td colspan='3'>Failed to load the XML file.</td></tr>";
            }
        ?>
    </table>
</body>
</html>

